package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.infrastructure.database.entity.ProductPackageDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductPackageRepository extends JpaRepository<ProductPackageDao, String> {
}
