package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.infrastructure.database.projection.ProductPackageProductProjection;
import java.util.List;

public interface ProductRepositoryCustom {
    List<ProductPackageProductProjection> searchProductsWithPackageTextPaged(String text, int page, int size);
}