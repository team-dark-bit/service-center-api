package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "InventoryBatch")
@Table(name = "inventory_batches")
public class InventoryBatchDao {

  @Id
  private String id;
  private String purchaseId;
  private String productPackageId;
  private LocalDateTime created;
  private LocalDateTime activationDate;
  private Integer quantityReceived;
  private Integer quantityAvailable;

}
