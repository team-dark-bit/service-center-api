package com.enterprise.servicecenter.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Sale {
  private String id;
  private String customerId;
  private String userId;
  private LocalDateTime operationDate;
  private Double igv;
  private Double subtotal;
  private Double total;
  private Double discount;
  private List<SaleDetail> details;
}
