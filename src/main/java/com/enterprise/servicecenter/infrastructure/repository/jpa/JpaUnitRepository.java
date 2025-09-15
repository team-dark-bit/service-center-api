package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.domain.model.UnitDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUnitRepository extends JpaRepository<UnitDao, String> {
}
