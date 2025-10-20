package com.enterprise.servicecenter.application.service.mapper;

import com.enterprise.servicecenter.application.dto.request.PurchaseProductRequest;
import com.enterprise.servicecenter.domain.model.PurchaseDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseDetailRequestDomainMapper {

    @Mapping(target = "purchaseUnitPrice", expression = "java(mapStringToDouble(request.getPurchaseUnitPrice()))")
    @Mapping(target = "saleUnitPrice", expression = "java(mapStringToDouble(request.getSaleUnitPrice()))")
    @Mapping(target = "subtotal", expression = "java(mapStringToDouble(request.getSubtotal()))")
    PurchaseDetail fromRequest(PurchaseProductRequest request);

    default Double mapStringToDouble(String value) {
        if (value == null) return null;
        value = value.trim();
        if (value.isEmpty()) return null;
        try {
            return Double.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
