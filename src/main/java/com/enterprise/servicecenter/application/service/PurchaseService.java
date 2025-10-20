package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreatePurchaseRequest;
import com.enterprise.servicecenter.application.port.in.PurchaseUseCase;
import com.enterprise.servicecenter.application.port.out.PurchaseDetailRepository;
import com.enterprise.servicecenter.application.port.out.PurchaseRepository;
import com.enterprise.servicecenter.application.service.mapper.PurchaseDetailRequestDomainMapper;
import com.enterprise.servicecenter.application.service.mapper.PurchaseRequestDomainMapper;
import com.enterprise.servicecenter.domain.model.PurchaseDetail;
import java.util.List;
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

    @Transactional
    @Override
    public void create(CreatePurchaseRequest request) {
        String purchaseId = purchaseRepository.save(purchaseRequestDomainMapper.fromRequest(request));
        List<PurchaseDetail> purchaseDetails = request.getProducts()
                .stream()
                .map(productReq -> {
                    PurchaseDetail pd = purchaseDetailRequestDomainMapper.fromRequest(productReq);
                    pd.setPurchaseId(purchaseId);
                    return pd;
                })
                .toList();
        purchaseDetailRepository.saveAll(purchaseDetails);
    }

}
