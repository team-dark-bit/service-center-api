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
  private String productName;
  private String categoryName;
  private String subCategoryName;
  private String brandName;
  List<PackageInventoryResponse> packages;
}
