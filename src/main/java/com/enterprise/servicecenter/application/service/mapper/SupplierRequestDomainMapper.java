package com.enterprise.servicecenter.application.service.mapper;

import com.enterprise.servicecenter.application.dto.request.CreateSupplierRequest;
import com.enterprise.servicecenter.domain.model.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierRequestDomainMapper {
    Supplier fromRequest(CreateSupplierRequest createSupplierRequest);
}
