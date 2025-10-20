package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain;

import com.enterprise.servicecenter.domain.model.PurchaseDetail;
import com.enterprise.servicecenter.infrastructure.database.entity.PurchaseDetailDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IdMapper.class})
public interface PurchaseDetailDaoDomainMapper {

    PurchaseDetail toDomain(PurchaseDetailDao dao);

    @Mapping(target = "id", source = "id", qualifiedByName = "generateId")
    PurchaseDetailDao toDao(PurchaseDetail domain);

}
