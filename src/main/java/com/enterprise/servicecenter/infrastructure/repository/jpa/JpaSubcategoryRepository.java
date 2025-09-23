package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.domain.model.SubcategoryDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaSubcategoryRepository extends JpaRepository<SubcategoryDao,String> {
  List<SubcategoryDao> findByCategoryId(String categoryId);
}
