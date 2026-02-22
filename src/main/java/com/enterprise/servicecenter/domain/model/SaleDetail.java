package com.enterprise.servicecenter.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaleDetail {
  private String id;
  private String itemType;
  private String productPackageId;
  private String serviceId;
  private Integer quantity;
  private Double unitPrice;
  private Double subtotal;
  private Double discount;
}
