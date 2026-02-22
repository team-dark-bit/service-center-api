package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateSaleRequest;

public interface SaleUseCase {
  void createSale(CreateSaleRequest createSaleRequest);
}
