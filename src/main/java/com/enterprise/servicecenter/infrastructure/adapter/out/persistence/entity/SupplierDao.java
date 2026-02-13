package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Supplier")
@Table(name = "suppliers")
public class SupplierDao {

  @Id
  private String id;

  private String name;
  private String documentType;
  private String documentNumber;
  private String description;
  private String address;
  private String phone;
  private String email;
  private boolean active;

  public SupplierDao() {}

}
