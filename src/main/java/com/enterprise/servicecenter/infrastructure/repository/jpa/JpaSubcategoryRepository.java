package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.domain.model.SubcategoryDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSubcategoryRepository extends JpaRepository<SubcategoryDao,String> {
}
