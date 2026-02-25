package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.domain.model.InventoryBatch;
import java.util.List;

public interface InventoryBatchRepository {
  void save(InventoryBatch inventoryBatch);
  void saveAll(List<InventoryBatch> inventoryBatches);
  InventoryBatch findById(String id);
}
