package com.enterprise.servicecenter.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductPackage {

    private String id;
    private String productId;
    private String packageId;
    private String unitId;
    private Double quantity;
    private String codedName;
    private String imageUrl;
    private Boolean status;

}
