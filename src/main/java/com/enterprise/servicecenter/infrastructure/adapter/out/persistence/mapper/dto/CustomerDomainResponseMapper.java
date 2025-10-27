package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.dto;

import com.enterprise.servicecenter.application.dto.response.CustomerResponse;
import com.enterprise.servicecenter.domain.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerDomainResponseMapper {
    CustomerResponse toResponse(Customer customer);
}

