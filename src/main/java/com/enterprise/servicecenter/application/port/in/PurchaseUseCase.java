package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreatePurchaseRequest;

public interface PurchaseUseCase {
    void create(CreatePurchaseRequest request);
}
