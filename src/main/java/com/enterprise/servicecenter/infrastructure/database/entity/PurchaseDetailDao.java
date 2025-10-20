package com.enterprise.servicecenter.infrastructure.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PurchaseDetail")
@Table(name = "purchase_details")
public class PurchaseDetailDao {
    @Id
    private String id;

    private String purchaseId;
    private String productPackageId;
    private Integer quantity;
    private Double purchaseUnitPrice;
    private Double saleUnitPrice;
    private Double subtotal;

}
