package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity(name = "Sale")
@Table(name = "sales")
public class SaleDao {
  @Id
  private String id;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "sale_id")
  private List<SaleDetailDao> details = new ArrayList<>();

  private String customerId;
  private String userId;
  private LocalDateTime operationDate;
  private Double igv;
  private Double subtotal;
  private Double total;
  private Double discount;

  public void addDetail(SaleDetailDao detail) {
    details.add(detail);
  }

  public void removeDetail(SaleDetailDao detail) {
    details.remove(detail);
  }

}
