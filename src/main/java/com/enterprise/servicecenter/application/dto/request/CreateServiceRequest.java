package com.enterprise.servicecenter.application.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateServiceRequest {
  private String name;
  private String referencePrice;
}
