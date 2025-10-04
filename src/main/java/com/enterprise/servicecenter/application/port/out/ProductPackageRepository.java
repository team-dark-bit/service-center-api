package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.application.model.ProductPackage;
import java.util.List;

public interface ProductPackageRepository {
    void save(ProductPackage productPackage);
    void saveAll(List<ProductPackage> productPackageList);
}
