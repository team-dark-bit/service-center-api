package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain;

import com.enterprise.servicecenter.commons.util.IdGenerator;
import com.enterprise.servicecenter.domain.model.Supplier;
import com.enterprise.servicecenter.infrastructure.database.entity.SupplierDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SupplierDaoDomainMapper {

    Supplier toDomain(SupplierDao dao);

    @Mapping(target = "id", source = "id", qualifiedByName = "generateId")
    SupplierDao toDao(Supplier domain);

    @Named("generateId")
    default String generateId(String id) {
        return (id == null || id.isBlank()) ? IdGenerator.generateId() : id;
    }
}
