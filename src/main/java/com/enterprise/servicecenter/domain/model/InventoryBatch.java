package com.enterprise.servicecenter.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryBatch {
  private String id;
  private String purchaseId;
  private String productPackageId;
  private LocalDateTime created;
  private LocalDateTime activationDate;
  private Integer quantityReceived;
  private Integer quantityAvailable;
}
