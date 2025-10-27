package com.enterprise.servicecenter.infrastructure.adapter.in.web;

import com.enterprise.servicecenter.application.dto.request.CreateCustomerRequest;
import com.enterprise.servicecenter.application.dto.response.CustomerResponse;
import com.enterprise.servicecenter.application.port.in.CustomerUseCase;
import com.enterprise.servicecenter.commons.response.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@Validated
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerUseCase customerUseCase;

  @PostMapping
  public ResponseEntity<ApiResponse<Void>> createCustomer(
          @RequestBody
          @Valid
          CreateCustomerRequest createCustomerRequest
  ) {
    customerUseCase.create(createCustomerRequest);
    return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED.value(), "Customer created successfully", null));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<CustomerResponse>> findById(@PathVariable String id) {
    CustomerResponse customer = customerUseCase.findById(id);
    return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "Customer found", customer));
  }

  @GetMapping
  public ResponseEntity<ApiResponse<List<CustomerResponse>>> findAll() {
    List<CustomerResponse> customers = customerUseCase.findAll();
    return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "Customers found", customers));
  }

}

