package com.enterprise.servicecenter.application.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateProductPackageRequest {

    private String productId;
    private String packageId;
    private String unitId;
    private String quantity;
    private String codedName;
    private String imageUrl;
    private Boolean status;

}
