package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.application.model.Brand;
import java.util.List;

public interface BrandRepository {
  void save(Brand brand);
  Brand findById(String id);
  List<Brand> findAllByActiveTrue();
}
