package com.enterprise.servicecenter.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Brand {

  private String id;
  private String name;
  private String alias;
  private String description;
  private Boolean active;

}
