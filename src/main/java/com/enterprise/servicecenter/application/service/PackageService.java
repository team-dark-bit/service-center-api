package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreatePackageRequest;
import com.enterprise.servicecenter.application.model.Package;
import com.enterprise.servicecenter.application.port.in.PackageUseCase;
import com.enterprise.servicecenter.application.port.out.PackageRepository;
import com.enterprise.servicecenter.common.util.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PackageService implements PackageUseCase {

    private final PackageRepository packageRepository;

    @Override
    public void createPackage(CreatePackageRequest createPackageRequest) {
        packageRepository.save(buildPackage(createPackageRequest));
    }

    private Package buildPackage(CreatePackageRequest createPackageRequest) {
        Package pkg = new Package();
        pkg.setId(IdGenerator.generateId());
        pkg.setName(createPackageRequest.getName());
        pkg.setCode(createPackageRequest.getCode());
        return pkg;
    }
}
