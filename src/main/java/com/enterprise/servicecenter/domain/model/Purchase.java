package com.enterprise.servicecenter.domain.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Purchase {

    private String id;
    private String purchaseNumber;
    private String supplierId;
    private LocalDateTime purchaseDate;
    private String receiptType;
    private String receiptNumber;
    private Double totalAmount;
    private String purchaseType;

}
