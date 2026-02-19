package com.enterprise.servicecenter.application.dto.response.mapper;

import com.enterprise.servicecenter.application.dto.response.product.catalog.ProductCatalogResponse;
import com.enterprise.servicecenter.application.dto.response.product.inventory.ProductInventoryResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductInventoryResponseMapper {
  ProductInventoryResponse toResponse(ProductCatalogResponse response);
}
