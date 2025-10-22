package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain;

import com.enterprise.servicecenter.domain.model.Subcategory;
import com.enterprise.servicecenter.infrastructure.database.entity.SubcategoryDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IdMapper.class})
public interface SubcategoryDaoDomainMapper {

    Subcategory toDomain(SubcategoryDao dao);

    @Mapping(target = "id", source = "id", qualifiedByName = "generateId")
    SubcategoryDao toDao(Subcategory domain);

}
