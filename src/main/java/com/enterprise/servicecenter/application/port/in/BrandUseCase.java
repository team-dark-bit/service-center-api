package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateBrandRequest;
import com.enterprise.servicecenter.application.dto.response.BrandResponse;
import java.util.List;

public interface BrandUseCase {
  void createBrand(CreateBrandRequest createBrandRequest);
  BrandResponse findById(String brandId);
  List<BrandResponse> findAll();
}
