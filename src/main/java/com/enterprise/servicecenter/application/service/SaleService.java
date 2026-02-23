package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateSaleRequest;
import com.enterprise.servicecenter.application.port.in.SaleUseCase;
import com.enterprise.servicecenter.application.port.out.PurchaseRepository;
import com.enterprise.servicecenter.application.port.out.SaleRepository;
import com.enterprise.servicecenter.application.service.mapper.SaleRequestDomainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService implements SaleUseCase {

  private final SaleRepository saleRepository;
  private final SaleRequestDomainMapper saleRequestMapper;
  private final PurchaseRepository purchaseRepository;

  @Override
  public void createSale(CreateSaleRequest createSaleRequest) {
    saleRepository.save(saleRequestMapper.fromRequest(createSaleRequest));
  }
}
