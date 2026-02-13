package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository;

import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.UnitDao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUnitRepository extends JpaRepository<UnitDao, String> {
  List<UnitDao> findAllByActiveTrue();
}
