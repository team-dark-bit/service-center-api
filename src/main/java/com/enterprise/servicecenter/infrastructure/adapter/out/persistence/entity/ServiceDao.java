package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Service")
@Table(name = "services")
public class ServiceDao {

  @Id
  private String id;
  private String name;
  private Double referencePrice;
  private Boolean active;

}
