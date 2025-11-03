package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.response.product.ProductCatalogResponse;
import com.enterprise.servicecenter.application.dto.response.product.ProductInventoryResponse;
import java.util.List;

public interface ProductQueryUseCase {
  List<ProductCatalogResponse> listForCatalog(String input, int pageNumber, int pageSize);
  List<ProductInventoryResponse> listForInventory(String input, int pageNumber, int pageSize);
}
