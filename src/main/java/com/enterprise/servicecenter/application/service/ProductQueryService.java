package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.response.mapper.ProductInventoryResponseMapper;
import com.enterprise.servicecenter.application.dto.response.product.ProductPurchaseResponse;
import com.enterprise.servicecenter.application.dto.response.product.catalog.ProductCatalogResponse;
import com.enterprise.servicecenter.application.dto.response.product.inventory.PackageInventoryResponse;
import com.enterprise.servicecenter.application.dto.response.product.inventory.ProductInventoryBatchResponse;
import com.enterprise.servicecenter.application.dto.response.product.inventory.ProductInventoryResponse;
import com.enterprise.servicecenter.application.port.in.ProductQueryUseCase;
import com.enterprise.servicecenter.application.port.out.ProductRepository;
import com.enterprise.servicecenter.application.port.out.PurchaseRepository;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection.InventoryBatchProjection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductQueryService implements ProductQueryUseCase {

  private final ProductRepository productRepository;
  private final ProductInventoryResponseMapper productInventoryResponseMapper;
  private final PurchaseRepository purchaseRepository;

  @Override
  public List<ProductCatalogResponse> listForCatalog(String input, int pageNumber, int pageSize) {
    return productRepository.searchProductsForCatalog(input, pageNumber, pageSize);
  }

  @Override
  public List<ProductInventoryResponse> listForInventory(String input, int pageNumber, int pageSize) {
    // reutilizamos la búsqueda para catálogo que ya agrupa paquetes por producto
    List<ProductInventoryResponse> productInventoryResponseList =
            productRepository.searchProductsForCatalog(input, pageNumber, pageSize)
                    .stream()
                    .map(productInventoryResponseMapper::toResponse)
                    .toList();

    if (productInventoryResponseList.isEmpty()) {
      return Collections.emptyList();
    }

    // Para cada producto y cada package, obtenemos los batches desde PurchaseRepository
    productInventoryResponseList.forEach(product -> {
      List<PackageInventoryResponse> packages = product.getPackages();
      packages.forEach(pkg -> {
        String productPackageId = pkg.getProductPackageId();
        List<InventoryBatchProjection> projections = purchaseRepository.findByProductPackageId(productPackageId);
        if (projections == null || projections.isEmpty()) {
          pkg.setBatches(Collections.emptyList());
          return;
        }

        List<ProductInventoryBatchResponse> batches = projections.stream()
                .map(proj -> ProductInventoryBatchResponse.builder()
                        .purchaseNumber(proj.getPurchaseNumber())
                        .purchaseUnitPrice(proj.getPurchaseUnitPrice())
                        .saleUnitPrice(proj.getSaleUnitPrice())
                        .quantityAvailable(proj.getQuantityAvailable())
                        .build())
                .collect(Collectors.toList());

        pkg.setBatches(batches);
      });
    });

    // filtrar productos que NO tengan ningún batch en ninguno de sus packages
    return productInventoryResponseList.stream()
            .filter(product -> {
              List<PackageInventoryResponse> pkgs = product.getPackages();
              return pkgs.stream().anyMatch(p -> !p.getBatches().isEmpty());
            })
            .collect(Collectors.toList());

  }

  @Override
  public List<ProductPurchaseResponse> listForPurchase(String input, int pageNumber, int pageSize) {
    return productRepository.searchProductsForPurchase(input, pageNumber, pageSize);
  }
}
