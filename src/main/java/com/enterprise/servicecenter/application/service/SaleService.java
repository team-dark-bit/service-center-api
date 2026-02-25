package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateSaleRequest;
import com.enterprise.servicecenter.application.port.in.SaleUseCase;
import com.enterprise.servicecenter.application.port.out.InventoryBatchRepository;
import com.enterprise.servicecenter.application.port.out.ProductRepository;
import com.enterprise.servicecenter.application.port.out.SaleRepository;
import com.enterprise.servicecenter.application.service.mapper.SaleRequestDomainMapper;
import com.enterprise.servicecenter.domain.model.InventoryBatch;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection.InventoryBatchProjection;
import com.enterprise.servicecenter.infrastructure.config.exception.ApplicationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.enterprise.servicecenter.infrastructure.config.exception.RuntimeErrors.PRODUCT_QUANTITY_EXCEEDS_INVENTORY;
import static com.enterprise.servicecenter.infrastructure.config.exception.RuntimeErrors.PRODUCT_WITHOUT_INVENTORY;
import static com.enterprise.servicecenter.infrastructure.config.exception.RuntimeErrors.UPDATE_INVENTORY_ERROR;

@Service
@RequiredArgsConstructor
public class SaleService implements SaleUseCase {

  private final SaleRepository saleRepository;
  private final SaleRequestDomainMapper saleRequestMapper;
  private final ProductRepository productRepository;
  private final InventoryBatchRepository inventoryBatchRepository;

  @Override
  @Transactional
  public void createSale(CreateSaleRequest createSaleRequest) {

    // Para cada detalle de la venta: validar y consumir inventario por lotes
    createSaleRequest.getDetails().forEach(detail -> {
      String productPackageId = detail.getProductPackageId();

      // recuperar inventarios ordenados (del más antiguo al más nuevo)
      List<InventoryBatchProjection> inventoriesProjection =
              productRepository.listInventoryByProductPackageId(productPackageId);

      if (inventoriesProjection.isEmpty()) {
        throw new ApplicationException(PRODUCT_WITHOUT_INVENTORY, productPackageId);
      }

      int stock = inventoriesProjection.stream()
              .map(InventoryBatchProjection::getQuantityAvailable)
              .reduce(0, Integer::sum);
      if (stock < detail.getQuantity()) {
        throw new ApplicationException(PRODUCT_QUANTITY_EXCEEDS_INVENTORY, productPackageId, stock, detail.getQuantity());
      }

      // actualizar inventario consumiendo lotes
      updateInventory(inventoriesProjection, detail.getQuantity());

    });

    // save sale (queda dentro de la misma transacción)
    saleRepository.save(saleRequestMapper.fromRequest(createSaleRequest));
  }

  private void updateInventory(List<InventoryBatchProjection> inventoriesProjection, int quantityToConsume) {
    // construir lista de batches modificados
    List<InventoryBatch> batchesToSave = new ArrayList<>();

    boolean movedToNext = false; // indica que el lote anterior no alcanzó y pasamos al siguiente

    for (InventoryBatchProjection proj : inventoriesProjection) {
      if (quantityToConsume <= 0) break;

      // cargar el batch como entidad de dominio para actualizar
      InventoryBatch batch = inventoryBatchRepository.findById(proj.getInventoryBatchId());

      Integer available = batch.getQuantityAvailable();

      int consume = Math.min(available, quantityToConsume);
      int newAvailable = available - consume;

      batch.setQuantityAvailable(newAvailable);

      // si estamos empezando a usar este lote porque el anterior no alcanzó, actualizar activationDate
      if (movedToNext) {
        batch.setActivationDate(LocalDateTime.now());
      }

      batchesToSave.add(batch);

      // si este lote no cubrió todo, marcamos que pasaremos al siguiente
      if (consume == available && quantityToConsume - consume > 0) {
        movedToNext = true;
      }

      quantityToConsume -= consume;
    }

    if (quantityToConsume > 0) {
      // lanzar excepción si no se completó el consumo
      throw new ApplicationException(UPDATE_INVENTORY_ERROR);
    }

    // persistir cambios en lotes
    if (!batchesToSave.isEmpty()) {
      inventoryBatchRepository.saveAll(batchesToSave);
    }
  }
}
