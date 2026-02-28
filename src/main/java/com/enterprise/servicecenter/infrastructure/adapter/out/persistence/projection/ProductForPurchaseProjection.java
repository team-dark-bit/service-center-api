package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductForPurchaseProjection {

    private String productId;
    private String productPackageId;
    private String productName;
    private String codedName;
    private String sku;
    private String barcode;
    private String packageDescription;

}
