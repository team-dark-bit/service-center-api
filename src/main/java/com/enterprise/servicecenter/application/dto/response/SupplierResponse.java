package com.enterprise.servicecenter.application.dto.response;

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
public class SupplierResponse {
  private String name;
  private String documentType;
  private String documentNumber;
  private String description;
  private String address;
  private String phone;
  private String email;
  private boolean active;
}
