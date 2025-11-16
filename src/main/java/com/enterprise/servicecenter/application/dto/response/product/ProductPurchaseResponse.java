package com.enterprise.servicecenter.application.dto.response.product;

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
public class ProductPurchaseResponse {
  private String productId;
  private String productPackageId;
  private String productName;
  private String codedName;
  private String sku;
  private String barcode;
}
