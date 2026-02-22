package com.enterprise.servicecenter.infrastructure.adapter.in.web;

import com.enterprise.servicecenter.application.dto.request.CreateSaleRequest;
import com.enterprise.servicecenter.application.port.in.SaleUseCase;
import com.enterprise.servicecenter.commons.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
@Slf4j
@Validated
public class SaleController {

  private final SaleUseCase saleUseCase;

  public SaleController(SaleUseCase saleUseCase) {
    this.saleUseCase = saleUseCase;
  }

  @PostMapping
  public ResponseEntity<ApiResponse<Void>> createSale(
          @RequestBody
          @Valid
          CreateSaleRequest request
  ) {
    saleUseCase.createSale(request);
    return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED.value(), "Sale created successfully", null));
  }
}
