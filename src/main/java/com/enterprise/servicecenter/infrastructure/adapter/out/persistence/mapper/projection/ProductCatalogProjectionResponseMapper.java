package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.projection;

import com.enterprise.servicecenter.application.dto.response.product.ProductCatalogResponse;
import com.enterprise.servicecenter.infrastructure.database.projection.ProductForCatalogProjection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCatalogProjectionResponseMapper {
  ProductCatalogResponse toResponse(ProductForCatalogProjection projection);
}
