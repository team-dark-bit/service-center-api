package com.enterprise.servicecenter.application.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateProductRequest {

  private String brandId;
  private String subcategoryId;
  private String serviceCenterId;
  private String name;
  private String displayName;
  private String description;
  private String activeFrom;
  private String barcode;
  private String sku;

  private String packageId;
  private String unitId;
  private String quantity;
  private String codedName;
  private String imageUrl;
  private Boolean status;

}
