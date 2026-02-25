package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreatePurchaseRequest;
import com.enterprise.servicecenter.application.port.in.PurchaseUseCase;
import com.enterprise.servicecenter.application.port.out.InventoryBatchRepository;
import com.enterprise.servicecenter.application.port.out.PurchaseDetailRepository;
import com.enterprise.servicecenter.application.port.out.PurchaseRepository;
import com.enterprise.servicecenter.application.service.mapper.PurchaseDetailRequestDomainMapper;
import com.enterprise.servicecenter.application.service.mapper.PurchaseRequestDomainMapper;
import com.enterprise.servicecenter.domain.model.InventoryBatch;
import com.enterprise.servicecenter.domain.model.Purchase;
import com.enterprise.servicecenter.domain.model.PurchaseDetail;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PurchaseService implements PurchaseUseCase {

  private final PurchaseRepository purchaseRepository;
  private final PurchaseDetailRepository purchaseDetailRepository;
  private final PurchaseRequestDomainMapper purchaseRequestDomainMapper;
  private final PurchaseDetailRequestDomainMapper purchaseDetailRequestDomainMapper;
  private final InventoryBatchRepository inventoryBatchRepository;

  @Transactional
  @Override
  public void create(CreatePurchaseRequest request) {
    Purchase purchase = purchaseRequestDomainMapper.fromRequest(request);
    String purchaseId = purchaseRepository.save(purchase);
    List<PurchaseDetail> purchaseDetails = request.getProducts()
            .stream()
            .map(productReq -> {
              PurchaseDetail pd = purchaseDetailRequestDomainMapper.fromRequest(productReq);
              pd.setPurchaseId(purchaseId);
              return pd;
            })
            .toList();
    purchaseDetailRepository.saveAll(purchaseDetails);

    List<String> productPackageIds = purchaseDetails.stream()
            .map(PurchaseDetail::getProductPackageId)
            .distinct()
            .toList();

    Set<String> existingProductPackageIds = inventoryBatchRepository.findExistingProductPackageIds(productPackageIds);

    List<InventoryBatch> batches = purchaseDetails.stream()
            .map(purchaseDetail -> {
              LocalDateTime activationDate = evaluateActivationDate(purchaseDetail.getProductPackageId(), existingProductPackageIds);
              return InventoryBatch.builder()
                      .purchaseId(purchaseId)
                      .productPackageId(purchaseDetail.getProductPackageId())
                      .created(purchase.getPurchaseDate())
                      .activationDate(activationDate)
                      .quantityReceived(purchaseDetail.getQuantity())
                      .quantityAvailable(purchaseDetail.getQuantity())
                      .build();
            })
            .toList();
    inventoryBatchRepository.saveAll(batches);
  }

  private LocalDateTime evaluateActivationDate(String productPackageId, Set<String> existingProductPackageIds) {
    if (existingProductPackageIds.contains(productPackageId)) {
      return null;
    }
    return LocalDateTime.now();
  }

}
