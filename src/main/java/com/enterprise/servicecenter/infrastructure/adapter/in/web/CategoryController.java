package com.enterprise.servicecenter.infrastructure.adapter.in.web;

import com.enterprise.servicecenter.application.dto.request.CreateCategoryRequest;
import com.enterprise.servicecenter.application.dto.response.CategoryResponse;
import com.enterprise.servicecenter.application.dto.response.SubcategoryResponse;
import com.enterprise.servicecenter.application.port.in.CategoryUseCase;
import com.enterprise.servicecenter.application.port.in.SubcategoryCaseUse;
import com.enterprise.servicecenter.common.response.ApiResponse;
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
@RequestMapping("/categories")
@Slf4j
@Validated
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryUseCase categoryUseCase;
    private final SubcategoryCaseUse subcategoryCaseUse;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createCategory(
            @RequestBody
            @Valid
            CreateCategoryRequest createCategoryRequest) {
        categoryUseCase.createCategory(createCategoryRequest);
        return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED.value(), "Category created successfully", null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> findAll() {
        List<CategoryResponse> categories = categoryUseCase.findAll();
        return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "Categories found", categories));
    }

    @GetMapping("/{categoryId}/subcategories")
    public ResponseEntity<ApiResponse<List<SubcategoryResponse>>> findByCategoryId(@PathVariable String categoryId) {
      List<SubcategoryResponse> subcategories = subcategoryCaseUse.findByCategoryId(categoryId);
      return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "Subcategories found", subcategories));
    }

}
