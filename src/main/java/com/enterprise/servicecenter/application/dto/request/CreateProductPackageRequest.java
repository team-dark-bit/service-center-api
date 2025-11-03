package com.enterprise.servicecenter.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductPackageRequest {

    private String productId;
    private String packageId;
    private String unitId;
    private String quantity;
    private String codedName;
    private String imageUrl;
    private Boolean status;
    private String barcode;
    private String sku;
    private String description;

}
