package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.projection;

import com.enterprise.servicecenter.application.dto.response.product.ProductInventoryResponse;
import com.enterprise.servicecenter.infrastructure.database.projection.ProductForInventoryProjection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductInventoryProjectionResponseMapper {
  ProductInventoryResponse toResponse(ProductForInventoryProjection projection);
}
