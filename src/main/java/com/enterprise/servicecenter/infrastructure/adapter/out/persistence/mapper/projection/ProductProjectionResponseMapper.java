package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.projection;

import com.enterprise.servicecenter.application.dto.response.product.ProductPurchaseResponse;
import com.enterprise.servicecenter.infrastructure.database.projection.ProductForPurchaseProjection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductProjectionResponseMapper {
  ProductPurchaseResponse toResponse(ProductForPurchaseProjection projection);
}