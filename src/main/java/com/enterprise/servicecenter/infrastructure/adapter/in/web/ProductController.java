package com.enterprise.servicecenter.infrastructure.adapter.in.web;

import com.enterprise.servicecenter.application.dto.request.CreateProductRequest;
import com.enterprise.servicecenter.application.dto.response.ProductResponse;
import com.enterprise.servicecenter.application.port.in.ProductUseCase;
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
@RequestMapping("/products")
@Slf4j
@Validated
public class ProductController {

  private final ProductUseCase productUseCase;

  public ProductController(ProductUseCase productUseCase) {
    this.productUseCase = productUseCase;
  }

  @PostMapping
  public ResponseEntity<ApiResponse<Void>> createProduct(
          @RequestBody
          @Valid
          CreateProductRequest createProductRequest) {
    productUseCase.createProduct(createProductRequest);
    return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED.value(), "Product created successfully", null));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<ProductResponse>> findById(@PathVariable String id) {
    ProductResponse productResponse = productUseCase.findById(id);
    return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "Product found", productResponse));
  }

//  @GetMapping
//  public ResponseEntity<ApiResponse<Iterable<ProductResponse>>> findAll() {
////    Iterable<ProductResponse> products = productUseCase.findAll();
////    return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "Products retrieved", products));
//  }


}
