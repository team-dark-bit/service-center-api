package com.enterprise.servicecenter.application.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseProductRequest {
    private String productId;
    private String productPackageId;
    private String quantity;
    private String purchaseUnitPrice;
    private String saleUnitPrice;
    private String subtotal;
}
