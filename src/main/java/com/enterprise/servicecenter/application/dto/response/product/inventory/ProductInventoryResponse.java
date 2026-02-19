package com.enterprise.servicecenter.application.dto.response.product.inventory;

import java.util.List;
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
public class ProductInventoryResponse {
  private String productId;
  private String productPackageId;
  private String productName;
  private String packageCodedName;
  private String sku;
  private String barcode;
  private String imageUrl;
  private String brandName;
  private String categoryName;
  private String subCategoryName;
  List<PackageInventoryResponse> packages;
}
