package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository;

import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.SubcategoryDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaSubcategoryRepository extends JpaRepository<SubcategoryDao,String> {
  List<SubcategoryDao> findByCategoryId(String categoryId);
}
