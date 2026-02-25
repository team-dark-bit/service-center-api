package com.enterprise.servicecenter.application.dto.request;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatePurchaseRequest {
    private String supplierId;
    private String purchaseDate;
    private String receiptType;
    private String receiptNumber;
    private String totalAmount;
    private List<PurchaseProductRequest> products;
}
