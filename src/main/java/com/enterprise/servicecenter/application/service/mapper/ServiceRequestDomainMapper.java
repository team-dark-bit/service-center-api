package com.enterprise.servicecenter.application.service.mapper;

import com.enterprise.servicecenter.application.dto.request.CreateServiceRequest;
import com.enterprise.servicecenter.commons.util.IdGenerator;
import com.enterprise.servicecenter.commons.util.ParseUtil;
import com.enterprise.servicecenter.domain.model.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {IdGenerator.class, ParseUtil.class})
public interface ServiceRequestDomainMapper {

  @Mapping(target = "id", expression = "java(IdGenerator.generateId())")
  @Mapping(target = "referencePrice", expression = "java(ParseUtil.mapStringToDouble(request.getReferencePrice()))")
  Service fromRequest(CreateServiceRequest request);

}
