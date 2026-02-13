package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductForCatalogProjection {

  private String productId;
  private String productName;
  private String categoryName;
  private String subCategoryName;
  private String brandName;

  private String productPackageId;
  private String packageDescription;
  private String packageCodedName;
  private String sku;
  private String barcode;
  private String imageUrl;

}
