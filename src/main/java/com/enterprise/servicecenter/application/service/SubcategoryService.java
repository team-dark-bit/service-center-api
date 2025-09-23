package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateSubcategoryRequest;
import com.enterprise.servicecenter.application.dto.response.SubcategoryResponse;
import com.enterprise.servicecenter.application.model.Subcategory;
import com.enterprise.servicecenter.application.port.in.SubcategoryCaseUse;
import com.enterprise.servicecenter.application.port.out.SubcategoryRepository;
import com.enterprise.servicecenter.common.util.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubcategoryService implements SubcategoryCaseUse {
  private final SubcategoryRepository subcategoryRepository;
  @Override
  public void createSubcategory(CreateSubcategoryRequest createSubcategoryRequest) {
    subcategoryRepository.save(buildSubcategory(createSubcategoryRequest));
  }

  @Override
  public SubcategoryResponse findById(String subCategoryId) {
    return mapSubcategoryResponse(subcategoryRepository.findById(subCategoryId));
  }

  @Override
  public List<SubcategoryResponse> findByCategoryId(String categoryId) {
    return subcategoryRepository.findByCategoryId(categoryId)
            .stream()
            .map(this::mapSubcategoryResponse)
            .toList();
  }

  private Subcategory buildSubcategory(CreateSubcategoryRequest createSubcategoryRequest){
    Subcategory subcategory = new Subcategory();
    subcategory.setId(IdGenerator.generateId());
    subcategory.setName(createSubcategoryRequest.getName());
    subcategory.setDescription(createSubcategoryRequest.getDescription());
    return subcategory;
  }
  private  SubcategoryResponse mapSubcategoryResponse(Subcategory subcategory){
    return SubcategoryResponse.builder()
            .id(subcategory.getId())
            .name(subcategory.getName())
            .description(subcategory.getDescription())
            .build();
  }
}
