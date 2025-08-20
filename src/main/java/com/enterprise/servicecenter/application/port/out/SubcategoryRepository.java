package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.application.model.Subcategory;

public interface SubcategoryRepository {
  void save(Subcategory subcategory);
  Subcategory findById(String id);
}
