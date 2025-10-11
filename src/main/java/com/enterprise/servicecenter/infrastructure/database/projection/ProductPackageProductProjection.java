package com.enterprise.servicecenter.infrastructure.database.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductPackageProductProjection {

    private String productId;
    private String productName;
    private String sku;
    private String barcode;

}
