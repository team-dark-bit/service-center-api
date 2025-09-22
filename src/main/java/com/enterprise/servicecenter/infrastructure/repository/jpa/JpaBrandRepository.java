package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.domain.model.BrandDao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBrandRepository extends JpaRepository<BrandDao, String> {
    List<BrandDao> findAllByActiveTrue();
}
