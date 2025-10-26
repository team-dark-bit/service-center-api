package com.enterprise.servicecenter.infrastructure.repository.custom;

import com.enterprise.servicecenter.infrastructure.database.projection.ProductForCatalogProjection;
import com.enterprise.servicecenter.infrastructure.database.projection.ProductPackageProductProjection;
import java.util.List;

public interface ProductRepositoryCustom {
    List<ProductPackageProductProjection> searchProductsWithPackageTextPaged(String text, int page, int size);
    List<ProductForCatalogProjection> searchProductsForCatalog(String text, int page, int size);
}