package com.enterprise.servicecenter.application.dto.request;

import com.enterprise.servicecenter.common.util.validation.annotation.IsDecimal;
import com.enterprise.servicecenter.common.util.validation.annotation.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateProductRequest {

  private String name;
  private String description;

  @NotBlank(name = "price")
  @IsDecimal(numbers = 4, decimals = 2)
  private String price;

}
