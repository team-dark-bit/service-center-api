package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.application.model.Brand;

public interface BrandRepository {
  void save(Brand brand);
  Brand findById(String id);
}
