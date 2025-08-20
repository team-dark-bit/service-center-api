package com.enterprise.servicecenter.infrastructure.adapter.in.web;

import com.enterprise.servicecenter.application.dto.request.CreateBrandRequest;
import com.enterprise.servicecenter.application.dto.response.BrandResponse;
import com.enterprise.servicecenter.application.port.in.BrandCaseUse;
import com.enterprise.servicecenter.common.response.ApiResponse;
import jakarta.validation.Valid;
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
@RequestMapping("/brands")
@Slf4j
@Validated
public class BrandController {

  private final BrandCaseUse brandCaseUse;

  public BrandController(BrandCaseUse brandCaseUse) {
    this.brandCaseUse = brandCaseUse;
  }

  @PostMapping
  public ResponseEntity<ApiResponse<Void>> createBrand(
          @RequestBody
          @Valid
          CreateBrandRequest createBrandRequest
  ) {
    brandCaseUse.createBrand(createBrandRequest);
    return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED.value(), "Product created successfully", null));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<BrandResponse>> findById(@PathVariable String id) {
    BrandResponse brandResponse = brandCaseUse.findById(id);
    return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "Brand found", brandResponse));
  }
}
