package com.enterprise.servicecenter.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Category {
  private String id;
  private String name;
  private String description;
  private Boolean active;
}
