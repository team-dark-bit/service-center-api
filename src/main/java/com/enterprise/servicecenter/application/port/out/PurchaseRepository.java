package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.domain.model.Purchase;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection.InventoryBatchProjection;
import java.util.List;

public interface PurchaseRepository {
  String save(Purchase purchase);
  List<InventoryBatchProjection> findByProductPackageId(String productPackageId);
}
