package com.enterprise.servicecenter.infrastructure.database.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductForCatalogProjection {
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
