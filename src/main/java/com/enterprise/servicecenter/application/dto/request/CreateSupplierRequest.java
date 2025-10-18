package com.enterprise.servicecenter.application.dto.request;

import com.enterprise.servicecenter.commons.util.validation.annotation.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateSupplierRequest {

  @NotBlank(name = "name")
  private String name;

  private String documentType;
  private String documentNumber;
  private String description;
  private String address;
  private String phone;
  private String email;
  private boolean active;

}