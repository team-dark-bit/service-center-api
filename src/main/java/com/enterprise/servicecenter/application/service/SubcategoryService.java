package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateSubcategoryRequest;
import com.enterprise.servicecenter.application.dto.response.SubcategoryResponse;
import com.enterprise.servicecenter.application.port.in.SubcategoryCaseUse;
import com.enterprise.servicecenter.application.port.out.SubcategoryRepository;
import com.enterprise.servicecenter.application.service.mapper.SubcategoryRequestDomainMapper;
import com.enterprise.servicecenter.domain.model.Subcategory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubcategoryService implements SubcategoryCaseUse {

  private final SubcategoryRepository subcategoryRepository;
  private final SubcategoryRequestDomainMapper domainRequestMapper;

  @Override
  public void createSubcategory(CreateSubcategoryRequest createSubcategoryRequest) {
    subcategoryRepository.save(domainRequestMapper.fromRequest(createSubcategoryRequest));
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

  private  SubcategoryResponse mapSubcategoryResponse(Subcategory subcategory){
    return SubcategoryResponse.builder()
            .id(subcategory.getId())
            .name(subcategory.getName())
            .description(subcategory.getDescription())
            .build();
  }
}
