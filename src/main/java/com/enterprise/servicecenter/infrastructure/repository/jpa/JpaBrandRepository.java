package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.infrastructure.database.entity.BrandDao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBrandRepository extends JpaRepository<BrandDao, String> {
    List<BrandDao> findAllByActiveTrue();
}
