package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class InventoryBatchProjection {
  private final String purchaseId;
  private final String inventoryBatchId;
  private final String purchaseNumber;
  private final Double purchaseUnitPrice;
  private final Double saleUnitPrice;
  private final Integer quantityAvailable;
  private final LocalDateTime purchaseDate;

  public InventoryBatchProjection(
          String purchaseId,
          String inventoryBatchId,
          String purchaseNumber,
          Double purchaseUnitPrice,
          Double saleUnitPrice,
          Integer quantityAvailable,
          Timestamp purchaseDateTs) {
    this.purchaseId = purchaseId;
    this.inventoryBatchId = inventoryBatchId;
    this.purchaseNumber = purchaseNumber;
    this.purchaseUnitPrice = purchaseUnitPrice;
    this.saleUnitPrice = saleUnitPrice;
    this.quantityAvailable = quantityAvailable;
    this.purchaseDate = purchaseDateTs != null ? purchaseDateTs.toLocalDateTime() : null;
  }
}
