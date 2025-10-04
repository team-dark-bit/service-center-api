package com.enterprise.servicecenter.application.dto.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

  private String brandId;
  private String subcategoryId;
  private String serviceCenterId;
  private String name;
  private String displayName;
  private String description;
  private String activeFrom;

  private List<CreateProductPackageRequest> packages;

}
