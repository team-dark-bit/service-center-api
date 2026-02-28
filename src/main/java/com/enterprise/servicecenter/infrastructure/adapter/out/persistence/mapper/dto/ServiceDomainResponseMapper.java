package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.dto;

import com.enterprise.servicecenter.application.dto.response.ServiceResponse;
import com.enterprise.servicecenter.domain.model.Service;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceDomainResponseMapper {
  ServiceResponse toResponse(Service service);
}

