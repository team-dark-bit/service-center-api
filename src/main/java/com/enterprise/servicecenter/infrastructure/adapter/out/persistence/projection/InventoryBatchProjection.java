package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InventoryBatchProjection {
  private String purchaseId;
  private String purchaseNumber;
  private Double purchaseUnitPrice;
  private Double saleUnitPrice;
  private Integer quantityAvailable;
}
