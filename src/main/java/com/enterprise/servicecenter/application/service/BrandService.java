package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateBrandRequest;
import com.enterprise.servicecenter.application.dto.response.BrandResponse;
import com.enterprise.servicecenter.application.model.Brand;
import com.enterprise.servicecenter.application.port.in.BrandUseCase;
import com.enterprise.servicecenter.application.port.out.BrandRepository;
import com.enterprise.servicecenter.common.util.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService implements BrandUseCase {

  private final BrandRepository brandRepository;

  @Override
  public void createBrand(CreateBrandRequest createBrandRequest) {
    brandRepository.save(buildBrand(createBrandRequest));
  }

  @Override
  public BrandResponse findById(String brandId) {
    return mapBrandResponse(brandRepository.findById(brandId));
  }

  private Brand buildBrand(CreateBrandRequest createBrandRequest) {
    Brand brand = new Brand();
    brand.setId(IdGenerator.generateId());
    brand.setName(createBrandRequest.getName());
    brand.setAlias(createBrandRequest.getAlias());
    brand.setDescription(createBrandRequest.getDescription());
    return brand;
  }

  private BrandResponse mapBrandResponse(Brand brand) {
    return BrandResponse.builder()
            .id(brand.getId())
            .name(brand.getName())
            .alias(brand.getAlias())
            .description(brand.getDescription())
            .build();
  }
}
