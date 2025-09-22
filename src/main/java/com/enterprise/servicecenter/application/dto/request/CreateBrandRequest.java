package com.enterprise.servicecenter.application.dto.request;

import com.enterprise.servicecenter.common.util.validation.annotation.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateBrandRequest {

  @NotBlank(name = "name")
  private String name;

  private String alias;
  private String description;
  private Boolean active;
}
