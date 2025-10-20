package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.domain.model.PurchaseDetail;
import java.util.List;

public interface PurchaseDetailRepository {
  void save(PurchaseDetail purchaseDetail);
  void saveAll(List<PurchaseDetail> purchaseDetails);
}
