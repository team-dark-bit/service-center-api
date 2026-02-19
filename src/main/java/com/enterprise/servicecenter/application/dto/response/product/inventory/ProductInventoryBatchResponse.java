package com.enterprise.servicecenter.application.dto.response.product.inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInventoryBatchResponse {
  private String purchaseNumber;
  private Double purchaseUnitPrice;
  private Double saleUnitPrice;
  private Integer quantityAvailable;
}
