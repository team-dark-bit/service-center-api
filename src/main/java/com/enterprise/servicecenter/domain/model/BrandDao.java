package com.enterprise.servicecenter.domain.model;

import com.enterprise.servicecenter.application.model.Brand;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Brand")
@Table(name = "brands")
public class BrandDao {

  @Id
  private String id;

  private String name;
  private String alias;
  private String description;
  private Boolean active;

  protected BrandDao () {}

  public BrandDao(Brand brand) {
    this.id = brand.getId();
    this.name = brand.getName();
    this.alias = brand.getAlias();
    this.description = brand.getDescription();
    this.active = brand.getActive();
  }

  public Brand toDomain() {
    Brand brand = new Brand();
    brand.setId(this.id);
    brand.setName(this.name);
    brand.setAlias(this.alias);
    brand.setDescription(this.description);
    brand.setActive(this.active);
    return brand;
  }
}
