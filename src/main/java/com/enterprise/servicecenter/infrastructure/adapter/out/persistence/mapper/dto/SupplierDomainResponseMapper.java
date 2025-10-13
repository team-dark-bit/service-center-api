package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.dto;

import com.enterprise.servicecenter.application.dto.response.SupplierResponse;
import com.enterprise.servicecenter.domain.model.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierDomainResponseMapper {
    SupplierResponse toResponse(Supplier supplier);
}
