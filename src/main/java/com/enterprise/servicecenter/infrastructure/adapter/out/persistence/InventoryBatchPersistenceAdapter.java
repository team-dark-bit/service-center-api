package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.port.out.InventoryBatchRepository;
import com.enterprise.servicecenter.domain.model.InventoryBatch;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain.InventoryBatchDaoDomainMapper;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.InventoryBatchDao;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.JpaInventoryBatchRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
}
