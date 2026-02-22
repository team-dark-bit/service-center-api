package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain;

import com.enterprise.servicecenter.domain.model.Sale;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.SaleDao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleDaoDomainMapper {
  Sale toDomain(SaleDao dao);
  SaleDao toDao(Sale domain);
}
