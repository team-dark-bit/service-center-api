package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateSubcategoryRequest;
import com.enterprise.servicecenter.application.dto.response.SubcategoryResponse;

public interface SubcategoryCaseUse {
  void createSubcategory(CreateSubcategoryRequest createSubcategoryRequest);
  SubcategoryResponse findById(String subCategoryId);
}
