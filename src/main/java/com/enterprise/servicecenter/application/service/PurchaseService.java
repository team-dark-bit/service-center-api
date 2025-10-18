package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreatePurchaseRequest;
import com.enterprise.servicecenter.application.port.in.PurchaseUseCase;
import com.enterprise.servicecenter.application.port.out.PurchaseRepository;
import com.enterprise.servicecenter.application.service.mapper.PurchaseRequestDomainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseService implements PurchaseUseCase {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseRequestDomainMapper purchaseRequestDomainMapper;

    @Override
    public void create(CreatePurchaseRequest request) {
        purchaseRepository.save(purchaseRequestDomainMapper.fromRequest(request));
    }

}
