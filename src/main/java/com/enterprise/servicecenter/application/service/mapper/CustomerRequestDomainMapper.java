package com.enterprise.servicecenter.application.service.mapper;

import com.enterprise.servicecenter.application.dto.request.CreateCustomerRequest;
import com.enterprise.servicecenter.domain.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerRequestDomainMapper {
    Customer fromRequest(CreateCustomerRequest createCustomerRequest);
}

