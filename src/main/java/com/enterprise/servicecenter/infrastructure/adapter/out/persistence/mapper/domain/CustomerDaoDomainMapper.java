package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain;

import com.enterprise.servicecenter.domain.model.Customer;
import com.enterprise.servicecenter.infrastructure.database.entity.CustomerDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IdMapper.class})
public interface CustomerDaoDomainMapper {

  Customer toDomain(CustomerDao dao);

  @Mapping(target = "id", source = "id", qualifiedByName = "generateId")
  CustomerDao toDao(Customer domain);
}
