package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.domain.model.Subcategory;

import java.util.List;

public interface SubcategoryRepository {
  void save(Subcategory subcategory);
  Subcategory findById(String id);
  List<Subcategory> findByCategoryId(String categoryId);
}
