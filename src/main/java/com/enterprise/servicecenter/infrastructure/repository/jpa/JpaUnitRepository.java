package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.infrastructure.database.entity.UnitDao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUnitRepository extends JpaRepository<UnitDao, String> {
  List<UnitDao> findAllByActiveTrue();
}
