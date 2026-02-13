package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.port.out.PurchaseDetailRepository;
import com.enterprise.servicecenter.domain.model.PurchaseDetail;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain.PurchaseDetailDaoDomainMapper;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.PurchaseDetailDao;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.JpaPurchaseDetailRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PurchaseDetailPersistenceAdapter implements PurchaseDetailRepository {

  private final JpaPurchaseDetailRepository jpaPurchaseDetailRepository;
  private final PurchaseDetailDaoDomainMapper domainMapper;

  @Override
  public void save(PurchaseDetail purchaseDetail) {
    jpaPurchaseDetailRepository.save(domainMapper.toDao(purchaseDetail));
  }

  @Override
  public void saveAll(List<PurchaseDetail> purchaseDetails) {
    List<PurchaseDetailDao> detailDaoList = purchaseDetails.stream()
            .map(domainMapper::toDao)
            .toList();
    jpaPurchaseDetailRepository.saveAll(detailDaoList);
  }
}
