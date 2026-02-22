package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "SaleDetail")
@Table(name = "sale_details")
public class SaleDetailDao {
  @Id
  private String id;

  private String itemType;
  private String productPackageId;
  private String serviceId;
  private Integer quantity;
  private Double unitPrice;
  private Double subtotal;
  private Double discount;
}
