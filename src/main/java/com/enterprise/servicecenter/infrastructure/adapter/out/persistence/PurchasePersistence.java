package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.port.out.PurchaseRepository;
import com.enterprise.servicecenter.domain.model.Purchase;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain.PurchaseDaoDomainMapper;
import com.enterprise.servicecenter.infrastructure.repository.jpa.JpaPurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PurchasePersistence implements PurchaseRepository {

  private final JpaPurchaseRepository jpaPurchaseRepository;
  private final PurchaseDaoDomainMapper purchaseDaoDomainMapper;

  @Override
  public void save(Purchase purchase) {
    jpaPurchaseRepository.save(purchaseDaoDomainMapper.toDao(purchase));
  }
}
