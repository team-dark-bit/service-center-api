package com.enterprise.servicecenter.application.dto.response.product.catalog;

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
public class ProductCatalogResponse {

  private String productId;
  private String productName;
  private String categoryName;
  private String subCategoryName;
  private String brandName;
  private List<PackageCatalogResponse> packages;

}
