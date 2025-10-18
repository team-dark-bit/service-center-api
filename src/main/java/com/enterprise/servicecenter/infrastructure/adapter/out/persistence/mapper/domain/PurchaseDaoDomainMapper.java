package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain;

import com.enterprise.servicecenter.commons.util.IdGenerator;
import com.enterprise.servicecenter.domain.model.Purchase;
import com.enterprise.servicecenter.infrastructure.database.entity.PurchaseDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PurchaseDaoDomainMapper {

    Purchase toDomain(PurchaseDao dao);

    @Mapping(target = "id", source = "id", qualifiedByName = "generateId")
    PurchaseDao toDao(Purchase domain);

    @Named("generateId")
    default String generateId(String id) {
        return (id == null || id.isBlank()) ? IdGenerator.generateId() : id;
    }
}
