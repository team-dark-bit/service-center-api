package com.enterprise.servicecenter.infrastructure.adapter.in.web;

import com.enterprise.servicecenter.application.dto.request.CreateSubcategoryRequest;
import com.enterprise.servicecenter.application.dto.response.SubcategoryResponse;
import com.enterprise.servicecenter.application.port.in.SubcategoryCaseUse;
import com.enterprise.servicecenter.common.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
@RequestMapping("/subcategory")
@Slf4j
@Validated
@AllArgsConstructor
public class SubcategoryController {

  private final SubcategoryCaseUse subcategoryCaseUse;

  @PostMapping
  public ResponseEntity<ApiResponse<Void>> createSubcategory(
          @RequestBody
          @Valid
          CreateSubcategoryRequest createSubcategoryRequest){
    subcategoryCaseUse.creteSubcategory(createSubcategoryRequest);
    return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED.value(),"Subcategory created successfully", null));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<SubcategoryResponse>> findById(@PathVariable String id){
    SubcategoryResponse subcategoryResponse = subcategoryCaseUse.findById(id);
    return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "Subcategory found",subcategoryResponse));
  }


}
