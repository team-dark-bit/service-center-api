package com.enterprise.servicecenter.application.dto.request;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateSaleRequest {

  private String customerId;
  private String userId;
  private Double igv;
  private Double subtotal;
  private Double total;
  private Double discount;
  private List<CreateSaleDetailRequest> details;

}
