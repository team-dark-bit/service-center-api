package com.enterprise.servicecenter.application.service.mapper;

import com.enterprise.servicecenter.application.dto.request.CreatePurchaseRequest;
import com.enterprise.servicecenter.commons.util.DateUtil;
import com.enterprise.servicecenter.domain.model.Purchase;
import java.time.LocalDateTime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseRequestDomainMapper {

    @Mapping(target = "totalAmount", expression = "java(mapStringToDouble(request.getTotalAmount()))")
    @Mapping(target = "purchaseDate", expression = "java(parseLocalDateTime(request.getPurchaseDate()))")
    Purchase fromRequest(CreatePurchaseRequest request);

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

    default LocalDateTime parseLocalDateTime(String value) {
        return DateUtil.toLocalDateTime(value);
    }
}
