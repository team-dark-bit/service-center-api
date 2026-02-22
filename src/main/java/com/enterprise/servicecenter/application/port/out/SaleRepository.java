package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.domain.model.Sale;

public interface SaleRepository {
  void save(Sale sale);
}
