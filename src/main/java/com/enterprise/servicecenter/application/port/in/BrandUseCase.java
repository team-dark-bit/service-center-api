package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateBrandRequest;
import com.enterprise.servicecenter.application.dto.response.BrandResponse;

public interface BrandUseCase {
  void createBrand(CreateBrandRequest createBrandRequest);
  BrandResponse findById(String brandId);
}
