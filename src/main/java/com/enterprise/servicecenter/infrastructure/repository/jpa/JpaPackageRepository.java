package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.domain.model.PackageDao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPackageRepository extends JpaRepository<PackageDao, String> {
    List<PackageDao> findAllByActiveTrue();
}
