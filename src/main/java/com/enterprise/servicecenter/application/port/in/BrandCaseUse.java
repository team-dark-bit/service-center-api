package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateBrandRequest;

public interface BrandCaseUse {
  void createBrand(CreateBrandRequest createBrandRequest);
}
