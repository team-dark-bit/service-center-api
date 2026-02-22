package com.enterprise.servicecenter.application.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateSaleDetailRequest {

  private String itemType;
  private String productPackageId;
  private String serviceId;
  private Integer quantity;
  private Double unitPrice;
  private Double subtotal;
  private Double discount;

}
