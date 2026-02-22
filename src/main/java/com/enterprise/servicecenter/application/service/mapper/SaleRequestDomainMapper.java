package com.enterprise.servicecenter.application.service.mapper;

import com.enterprise.servicecenter.application.dto.request.CreateSaleDetailRequest;
import com.enterprise.servicecenter.application.dto.request.CreateSaleRequest;
import com.enterprise.servicecenter.commons.util.IdGenerator;
import com.enterprise.servicecenter.domain.model.Sale;
import com.enterprise.servicecenter.domain.model.SaleDetail;
import java.time.LocalDateTime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {IdGenerator.class, LocalDateTime.class})
public interface SaleRequestDomainMapper {
  @Mapping(target = "id", expression = "java(IdGenerator.generateId())")
  @Mapping(target = "operationDate", expression = "java(LocalDateTime.now())")
  Sale fromRequest(CreateSaleRequest request);

  // MapStruct aplicará este mapeo a cada elemento de la lista `details`
  @Mapping(target = "id", expression = "java(IdGenerator.generateId())")
  SaleDetail fromRequest(CreateSaleDetailRequest request);
}
