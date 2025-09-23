package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.application.model.Subcategory;
import com.enterprise.servicecenter.domain.model.SubcategoryDao;

import java.util.List;

public interface SubcategoryRepository {
  void save(Subcategory subcategory);
  Subcategory findById(String id);
  List<Subcategory> findByCategoryId(String categoryId);
}
