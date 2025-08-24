package com.enterprise.servicecenter.domain.model;

import com.enterprise.servicecenter.application.model.Subcategory;
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
  private String name;
  private String description;

  protected SubcategoryDao(){}

  public SubcategoryDao(Subcategory subcategory){
    this.id = subcategory.getId();
    this.name = subcategory.getName();
    this.description = subcategory.getDescription();
  }
  public Subcategory toDomain(){
    Subcategory subcategory = new Subcategory();
    subcategory.setId(this.id);
    subcategory.setName(this.name);
    subcategory.setDescription(this.description);
    return subcategory;
  }
}
