package com.enterprise.servicecenter.application.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private String id;

    private String brandId;
    private String subcategoryId;
    private String serviceCenterId;
    private String name;
    private String displayName;
    private String description;
    private Boolean active;
    private LocalDateTime activeFrom;
    private LocalDateTime activeTo;
    private String barcode;
    private String sku;

}
