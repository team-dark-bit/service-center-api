package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateProductPackageRequest;

public interface ProductPackageUseCase {
    void createProductPackage(CreateProductPackageRequest createProductPackageRequest);
}
