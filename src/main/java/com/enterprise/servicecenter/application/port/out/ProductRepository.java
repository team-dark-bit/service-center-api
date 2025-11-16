package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.application.dto.response.product.catalog.ProductCatalogResponse;
import com.enterprise.servicecenter.application.dto.response.product.ProductInventoryResponse;
import com.enterprise.servicecenter.application.dto.response.product.ProductPurchaseResponse;
import com.enterprise.servicecenter.domain.model.Product;
import java.util.List;

public interface ProductRepository {

    void save(Product product);
    Product findById(String id);
    List<ProductPurchaseResponse> searchProductsForPurchase(String input, int pageNumber, int pageSize);
    List<ProductCatalogResponse> searchProductsForCatalog(String input, int pageNumber, int pageSize);
    List<ProductInventoryResponse> searchProductsForInventory(String input, int pageNumber, int pageSize);

}
