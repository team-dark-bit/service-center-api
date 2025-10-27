package com.enterprise.servicecenter.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer {

  private String id;
  private String fullName;
  private String companyName;
  private String documentType;
  private String documentNumber;
  private String phoneNumber;
  private boolean active;

}

