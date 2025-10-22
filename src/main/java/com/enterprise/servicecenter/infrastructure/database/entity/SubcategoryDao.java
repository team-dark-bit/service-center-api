package com.enterprise.servicecenter.infrastructure.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Subcategory")
@Table(name = "subcategories")
public class SubcategoryDao {
  @Id
  private String id;
  private String categoryId;
  private String name;
  private String description;

  public SubcategoryDao() {}

}
