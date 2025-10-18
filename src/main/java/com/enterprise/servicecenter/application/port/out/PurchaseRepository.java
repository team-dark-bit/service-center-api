package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.domain.model.Purchase;

public interface PurchaseRepository {
  void save(Purchase brand);
}
