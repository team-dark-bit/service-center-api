package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductForInventoryProjection {
  private String productId;//@@
  private String productPackageId;//
  private String productName;//
  private String packageCodedName;//
  private String sku;//
  private String barcode;//
  private String imageUrl;//
  private String brandName;//
  private String categoryName;//
  private String subCategoryName;//
}
