package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreatePackageRequest;
import com.enterprise.servicecenter.application.dto.response.PackageResponse;
import com.enterprise.servicecenter.application.model.Package;
import com.enterprise.servicecenter.application.port.in.PackageUseCase;
import com.enterprise.servicecenter.application.port.out.PackageRepository;
import com.enterprise.servicecenter.common.util.IdGenerator;
import java.util.List;
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

    @Override
    public List<PackageResponse> findAll() {
        return packageRepository.findAllByActiveTrue()
                .stream()
                .map(this::buildPackageResponse)
                .toList();
    }

    private Package buildPackage(CreatePackageRequest createPackageRequest) {
        Package pkg = new Package();
        pkg.setId(IdGenerator.generateId());
        pkg.setName(createPackageRequest.getName());
        pkg.setCode(createPackageRequest.getCode());
        return pkg;
    }

    private PackageResponse buildPackageResponse(Package pkg) {
        return PackageResponse.builder()
                .id(pkg.getId())
                .name(pkg.getName())
                .code(pkg.getCode())
                .build();
    }
}
