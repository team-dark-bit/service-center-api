package com.enterprise.servicecenter.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseDetail {

    private String id;
    private String purchaseId;
    private String productPackageId;
    private Integer quantity;
    private Double purchaseUnitPrice;
    private Double saleUnitPrice;
    private Double subtotal;

}
