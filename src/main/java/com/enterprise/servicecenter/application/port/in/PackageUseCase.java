package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreatePackageRequest;

public interface PackageUseCase {
    void createPackage(CreatePackageRequest createPackageRequest);
}
