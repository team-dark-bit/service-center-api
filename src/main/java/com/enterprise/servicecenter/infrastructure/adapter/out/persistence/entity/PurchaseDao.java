package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Purchase")
@Table(name = "purchases")
public class PurchaseDao {
    @Id
    private String id;

    private String purchaseNumber;
    private String supplierId;
    private LocalDateTime purchaseDate;
    private String receiptType;
    private String receiptNumber;
    private Double totalAmount;
    private String purchaseType;
}
