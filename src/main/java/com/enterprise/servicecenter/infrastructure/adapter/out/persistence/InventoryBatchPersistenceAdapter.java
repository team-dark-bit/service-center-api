package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.port.out.InventoryBatchRepository;
import com.enterprise.servicecenter.domain.model.InventoryBatch;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.InventoryBatchDao;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain.InventoryBatchDaoDomainMapper;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.JpaInventoryBatchRepository;
import com.enterprise.servicecenter.infrastructure.config.exception.ApplicationException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import static com.enterprise.servicecenter.infrastructure.config.exception.RuntimeErrors.INVENTORY_BATCH_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class InventoryBatchPersistenceAdapter implements InventoryBatchRepository {

  private final JpaInventoryBatchRepository jpaInventoryBatchRepository;
  private final InventoryBatchDaoDomainMapper inventoryBatchDomainMapper;

  @Override
  public void save(InventoryBatch inventoryBatch) {
    jpaInventoryBatchRepository.save(inventoryBatchDomainMapper.toDao(inventoryBatch));
  }

  @Override
  public void saveAll(List<InventoryBatch> inventoryBatches) {
    List<InventoryBatchDao> batchesDao = inventoryBatches.stream()
            .map(inventoryBatchDomainMapper::toDao)
            .toList();
    jpaInventoryBatchRepository.saveAll(batchesDao);
  }

  @Override
  public InventoryBatch findById(String id) {
    return jpaInventoryBatchRepository.findById(id)
            .map(inventoryBatchDomainMapper::toDomain)
            .orElseThrow(() -> new ApplicationException(INVENTORY_BATCH_NOT_FOUND, id));
  }

}
