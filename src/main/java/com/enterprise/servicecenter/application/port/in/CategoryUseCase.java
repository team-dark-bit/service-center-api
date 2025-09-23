package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateCategoryRequest;
import com.enterprise.servicecenter.application.dto.response.CategoryResponse;
import java.util.List;

public interface CategoryUseCase {
    void createCategory(CreateCategoryRequest createCategoryRequest);
    List<CategoryResponse> findAll();
}
