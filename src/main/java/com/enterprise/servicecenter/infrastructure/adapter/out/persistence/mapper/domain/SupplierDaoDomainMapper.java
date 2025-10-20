package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain;

import com.enterprise.servicecenter.domain.model.Supplier;
import com.enterprise.servicecenter.infrastructure.database.entity.SupplierDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IdMapper.class})
public interface SupplierDaoDomainMapper {

    Supplier toDomain(SupplierDao dao);

    @Mapping(target = "id", source = "id", qualifiedByName = "generateId")
    SupplierDao toDao(Supplier domain);
}
