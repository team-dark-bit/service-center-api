package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreatePackageRequest;
import com.enterprise.servicecenter.application.dto.response.PackageResponse;
import java.util.List;

public interface PackageUseCase {
    void createPackage(CreatePackageRequest createPackageRequest);
    List<PackageResponse> findAll();
}
