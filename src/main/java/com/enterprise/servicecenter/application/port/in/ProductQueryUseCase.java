package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.response.product.catalog.ProductCatalogResponse;
import com.enterprise.servicecenter.application.dto.response.product.inventory.ProductInventoryResponse;
import com.enterprise.servicecenter.application.dto.response.product.ProductPurchaseResponse;
import java.util.List;

public interface ProductQueryUseCase {
  List<ProductCatalogResponse> listForCatalog(String input, int pageNumber, int pageSize);
  List<ProductInventoryResponse> listForInventory(String input, int pageNumber, int pageSize);
  List<ProductPurchaseResponse> listForPurchase(String input, int pageNumber, int pageSize);
}
