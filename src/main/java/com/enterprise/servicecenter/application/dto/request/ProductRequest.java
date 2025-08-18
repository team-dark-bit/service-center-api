package com.enterprise.servicecenter.application.dto.request;

import com.enterprise.servicecenter.common.util.validation.annotation.IsDecimal;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductRequest {

  private String name;
  private String description;

  @NotBlank
  @IsDecimal(numbers = 4, decimals = 2)
  private String price;

}
