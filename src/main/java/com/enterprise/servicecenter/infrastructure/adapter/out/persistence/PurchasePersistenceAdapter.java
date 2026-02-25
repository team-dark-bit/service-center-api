package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.port.out.PurchaseRepository;
import com.enterprise.servicecenter.domain.model.Purchase;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain.PurchaseDaoDomainMapper;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.JpaPurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PurchasePersistenceAdapter implements PurchaseRepository {

  private final JpaPurchaseRepository jpaPurchaseRepository;
  private final PurchaseDaoDomainMapper purchaseDaoDomainMapper;
  private final PurchaseNumberGenerator purchaseNumberGenerator;

  @Override
  public String save(Purchase purchase) {
    purchase.setPurchaseNumber(purchaseNumberGenerator.next());
    return jpaPurchaseRepository.save(purchaseDaoDomainMapper.toDao(purchase)).getId();
  }
}
