package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper;

import com.enterprise.servicecenter.infrastructure.database.projection.ProductPackageProductProjection;
import com.enterprise.servicecenter.application.dto.response.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductProjectionMapper {
    ProductResponse toResponse(ProductPackageProductProjection projection);
}