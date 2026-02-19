package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class InventoryBatchProjection {
  private String purchaseId;
  private String purchaseNumber;
  private Double purchaseUnitPrice;
  private Double saleUnitPrice;
  private Integer quantityAvailable;
  private LocalDateTime purchaseDate;

  public InventoryBatchProjection(
          String purchaseId,
          String purchaseNumber,
          Double purchaseUnitPrice,
          Double saleUnitPrice,
          Integer quantityAvailable,
          Timestamp purchaseDateTs) {
    this.purchaseId = purchaseId;
    this.purchaseNumber = purchaseNumber;
    this.purchaseUnitPrice = purchaseUnitPrice;
    this.saleUnitPrice = saleUnitPrice;
    this.quantityAvailable = quantityAvailable;
    this.purchaseDate = purchaseDateTs != null ? purchaseDateTs.toLocalDateTime() : null;
  }
}
