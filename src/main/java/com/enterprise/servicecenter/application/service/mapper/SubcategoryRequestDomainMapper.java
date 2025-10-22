package com.enterprise.servicecenter.application.service.mapper;

import com.enterprise.servicecenter.application.dto.request.CreateSubcategoryRequest;
import com.enterprise.servicecenter.domain.model.Subcategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubcategoryRequestDomainMapper {
    Subcategory fromRequest(CreateSubcategoryRequest createSubcategoryRequest);
}
