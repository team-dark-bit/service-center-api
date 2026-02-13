package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.custom;

import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection.ProductForCatalogProjection;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection.ProductForInventoryProjection;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection.ProductForPurchaseProjection;
import java.util.List;

public interface ProductRepositoryCustom {
    List<ProductForPurchaseProjection> searchProductsForPurchase(String text, int page, int size);
    List<ProductForCatalogProjection> searchProductsForCatalog(String text, int page, int size);
    List<ProductForInventoryProjection> searchProductsForInventory(String text, int page, int size);
}