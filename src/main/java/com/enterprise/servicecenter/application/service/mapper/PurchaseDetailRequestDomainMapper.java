package com.enterprise.servicecenter.application.service.mapper;

import com.enterprise.servicecenter.application.dto.request.PurchaseProductRequest;
import com.enterprise.servicecenter.commons.util.ParseUtil;
import com.enterprise.servicecenter.domain.model.PurchaseDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {ParseUtil.class})
public interface PurchaseDetailRequestDomainMapper {

    @Mapping(target = "purchaseUnitPrice", expression = "java(ParseUtil.mapStringToDouble(request.getPurchaseUnitPrice()))")
    @Mapping(target = "saleUnitPrice", expression = "java(ParseUtil.mapStringToDouble(request.getSaleUnitPrice()))")
    @Mapping(target = "subtotal", expression = "java(ParseUtil.mapStringToDouble(request.getSubtotal()))")
    PurchaseDetail fromRequest(PurchaseProductRequest request);
    
}
