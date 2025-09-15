package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.application.model.ProductPackage;

public interface ProductPackageRepository {
    void save(ProductPackage productPackage);
}
