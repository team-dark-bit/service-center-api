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
public class ProductSalesResponse {
  private String productId;
  private String productPackageId;
  private String productName;
  private String packageCodedName;
  private Double saleUnitPrice;
  private int stock;
  private String imageUrl;
}
