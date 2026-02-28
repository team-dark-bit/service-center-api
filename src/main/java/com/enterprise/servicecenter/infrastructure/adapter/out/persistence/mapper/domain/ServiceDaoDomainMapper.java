package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain;

import com.enterprise.servicecenter.domain.model.Service;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.ServiceDao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceDaoDomainMapper {
  Service toDomain(ServiceDao dao);
  ServiceDao toDao(Service domain);
}
