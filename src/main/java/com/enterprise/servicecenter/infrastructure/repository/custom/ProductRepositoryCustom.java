package com.enterprise.servicecenter.infrastructure.repository.custom;

import com.enterprise.servicecenter.infrastructure.database.projection.ProductForCatalogProjection;
import com.enterprise.servicecenter.infrastructure.database.projection.ProductForInventoryProjection;
import com.enterprise.servicecenter.infrastructure.database.projection.ProductForPurchaseProjection;
import java.util.List;

public interface ProductRepositoryCustom {
    List<ProductForPurchaseProjection> searchProductsForPurchase(String text, int page, int size);
    List<ProductForCatalogProjection> searchProductsForCatalog(String text, int page, int size);
    List<ProductForInventoryProjection> searchProductsForInventory(String text, int page, int size);
}