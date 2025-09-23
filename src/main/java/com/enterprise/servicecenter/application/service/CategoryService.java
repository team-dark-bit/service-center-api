package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateCategoryRequest;
import com.enterprise.servicecenter.application.dto.response.CategoryResponse;
import com.enterprise.servicecenter.application.model.Category;
import com.enterprise.servicecenter.application.port.in.CategoryUseCase;
import com.enterprise.servicecenter.application.port.out.CategoryRepository;
import com.enterprise.servicecenter.common.util.IdGenerator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryUseCase {

    private final CategoryRepository categoryRepository;

    @Override
    public void createCategory(CreateCategoryRequest createCategoryRequest) {
        categoryRepository.save(buildCategory(createCategoryRequest));
    }

    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAllByActiveTrue()
                .stream()
                .map(this::mapCategoryResponse)
                .toList();
    }

    private Category buildCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = new Category();
        category.setId(IdGenerator.generateId());
        category.setName(createCategoryRequest.getName());
        category.setDescription(createCategoryRequest.getDescription());
        category.setActive(createCategoryRequest.getActive());

        return category;
    }

    private CategoryResponse mapCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}
