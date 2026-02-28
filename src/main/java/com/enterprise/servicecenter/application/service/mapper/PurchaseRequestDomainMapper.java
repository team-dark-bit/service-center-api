package com.enterprise.servicecenter.application.service.mapper;

import com.enterprise.servicecenter.application.dto.request.CreatePurchaseRequest;
import com.enterprise.servicecenter.commons.util.DateUtil;
import com.enterprise.servicecenter.commons.util.ParseUtil;
import com.enterprise.servicecenter.domain.model.Purchase;
import java.time.LocalDateTime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {ParseUtil.class})
public interface PurchaseRequestDomainMapper {

    @Mapping(target = "totalAmount", expression = "java(ParseUtil.mapStringToDouble(request.getTotalAmount()))")
    @Mapping(target = "purchaseDate", expression = "java(parseLocalDateTime(request.getPurchaseDate()))")
    Purchase fromRequest(CreatePurchaseRequest request);

    default LocalDateTime parseLocalDateTime(String value) {
        return DateUtil.toLocalDateTime(value);
    }
}
