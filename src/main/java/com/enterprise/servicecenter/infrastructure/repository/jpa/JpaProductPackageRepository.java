package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.domain.model.ProductPackageDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductPackageRepository extends JpaRepository<ProductPackageDao, String> {
}
