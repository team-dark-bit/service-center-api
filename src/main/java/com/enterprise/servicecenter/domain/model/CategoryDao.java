package com.enterprise.servicecenter.domain.model;

import com.enterprise.servicecenter.application.model.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Category")
@Table(name = "categories")
public class CategoryDao {
  @Id
  private String id;
  private String name;
  private String description;
  private Boolean active;

  protected CategoryDao(){}

  public CategoryDao(Category category){
    this.id = category.getId();
    this.name = category.getName();
    this.description = category.getDescription();
    this.active = category.getActive();
  }
  public Category toDomain(){
    Category category = new Category();
    category.setId(this.id);
    category.setName(this.name);
    category.setDescription(this.description);
    category.setActive(this.active);
    return category;
  }
}
