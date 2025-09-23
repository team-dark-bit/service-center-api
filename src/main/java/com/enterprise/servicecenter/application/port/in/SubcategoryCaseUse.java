package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateSubcategoryRequest;
import com.enterprise.servicecenter.application.dto.response.SubcategoryResponse;

import java.util.List;

public interface SubcategoryCaseUse {
  void createSubcategory(CreateSubcategoryRequest createSubcategoryRequest);
  SubcategoryResponse findById(String subCategoryId);
  List<SubcategoryResponse> findByCategoryId(String categoryId);
}
