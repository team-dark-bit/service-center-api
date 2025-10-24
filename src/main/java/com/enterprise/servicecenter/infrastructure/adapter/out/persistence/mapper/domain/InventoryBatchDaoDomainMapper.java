package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain;

import com.enterprise.servicecenter.domain.model.InventoryBatch;
import com.enterprise.servicecenter.infrastructure.database.entity.InventoryBatchDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IdMapper.class})
public interface InventoryBatchDaoDomainMapper {

  InventoryBatch toDomain(InventoryBatchDao dao);

  @Mapping(target = "id", source = "id", qualifiedByName = "generateId")
  InventoryBatchDao toDao(InventoryBatch inventoryBatch);

}
