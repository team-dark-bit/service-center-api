package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain;

import com.enterprise.servicecenter.domain.model.Purchase;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.PurchaseDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IdMapper.class})
public interface PurchaseDaoDomainMapper {

    Purchase toDomain(PurchaseDao dao);

    @Mapping(target = "id", source = "id", qualifiedByName = "generateId")
    PurchaseDao toDao(Purchase domain);

}
