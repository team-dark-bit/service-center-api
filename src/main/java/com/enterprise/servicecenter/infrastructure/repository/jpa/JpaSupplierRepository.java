package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.infrastructure.database.entity.SupplierDao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSupplierRepository extends JpaRepository<SupplierDao, String> {
    List<SupplierDao> findAllByActiveTrue();
}
