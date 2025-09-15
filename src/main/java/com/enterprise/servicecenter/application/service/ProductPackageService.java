package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateProductPackageRequest;
import com.enterprise.servicecenter.application.model.ProductPackage;
import com.enterprise.servicecenter.application.port.in.ProductPackageUseCase;
import com.enterprise.servicecenter.application.port.out.ProductPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductPackageService implements ProductPackageUseCase {

    private final ProductPackageRepository productPackageRepository;

    @Override
    public void createProductPackage(CreateProductPackageRequest createProductPackageRequest) {

    }

    private ProductPackage buildProductPackage(CreateProductPackageRequest createProductPackageRequest) {
        ProductPackage productPackage = new ProductPackage();

        return productPackage;
    }
}
