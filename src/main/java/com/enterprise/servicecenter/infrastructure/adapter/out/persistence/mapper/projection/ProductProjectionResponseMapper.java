package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.projection;

import com.enterprise.servicecenter.infrastructure.database.projection.ProductPackageProductProjection;
import com.enterprise.servicecenter.application.dto.response.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductProjectionResponseMapper {
  ProductResponse toResponse(ProductPackageProductProjection projection);
}