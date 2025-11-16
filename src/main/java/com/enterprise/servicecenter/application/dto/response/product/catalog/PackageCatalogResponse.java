package com.enterprise.servicecenter.application.dto.response.product.catalog;

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
public class PackageCatalogResponse {

  private String productPackageId;
  private String packageDescription;
  private String packageCodedName;
  private String sku;
  private String barcode;
  private String imageUrl;

}
