package com.enterprise.servicecenter.infrastructure.adapter.in.web;

import com.enterprise.servicecenter.application.dto.request.CreateSupplierRequest;
import com.enterprise.servicecenter.application.dto.response.SupplierResponse;
import com.enterprise.servicecenter.application.port.in.SupplierUseCase;
import com.enterprise.servicecenter.commons.response.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/suppliers")
@Slf4j
@Validated
@RequiredArgsConstructor
public class SupplierController {

  private final SupplierUseCase supplierUseCase;

  @PostMapping
  public ResponseEntity<ApiResponse<Void>> createSupplier(
          @RequestBody
          @Valid
          CreateSupplierRequest createSupplierRequest
  ) {
    supplierUseCase.create(createSupplierRequest);
    return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED.value(), "Supplier created successfully", null));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<SupplierResponse>> findById(@PathVariable String id) {
      SupplierResponse supplier = supplierUseCase.findById(id);
      return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "Supplier found", supplier));
  }

  @GetMapping
  public ResponseEntity<ApiResponse<List<SupplierResponse>>> findAll() {
    List<SupplierResponse> suppliers = supplierUseCase.findAll();
    return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "Suppliers found", suppliers));
  }

}
