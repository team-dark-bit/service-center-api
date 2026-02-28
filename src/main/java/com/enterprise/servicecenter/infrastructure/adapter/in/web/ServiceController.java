package com.enterprise.servicecenter.infrastructure.adapter.in.web;

import com.enterprise.servicecenter.application.dto.request.CreateBrandRequest;
import com.enterprise.servicecenter.application.dto.request.CreateServiceRequest;
import com.enterprise.servicecenter.application.port.in.ServiceUseCase;
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
@RequestMapping("/services")
@Slf4j
@Validated
public class ServiceController {

  private final ServiceUseCase serviceUseCase;

  public ServiceController(ServiceUseCase serviceUseCase) {
    this.serviceUseCase = serviceUseCase;
  }

  @PostMapping
  public ResponseEntity<ApiResponse<Void>> createService(
          @RequestBody
          @Valid
          CreateServiceRequest request
  ) {
    serviceUseCase.createService(request);
    return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED.value(), "Service created successfully", null));
  }

}
