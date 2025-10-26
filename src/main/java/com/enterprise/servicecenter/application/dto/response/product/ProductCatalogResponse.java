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
public class ProductCatalogResponse {
  private String productId;
  private String productPackageId;
  private String productName;
  private String packageCodedName;
  private String sku;
  private String barcode;
  private Double saleUnitPrice;
  private int stock;
  private String imageUrl;
  private String brandName;
  private String categoryName;
  private String subCategoryName;
}
