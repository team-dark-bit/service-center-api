package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.domain.model.Unit;
import com.enterprise.servicecenter.application.port.out.UnitRepository;
import com.enterprise.servicecenter.infrastructure.database.entity.UnitDao;
import com.enterprise.servicecenter.infrastructure.repository.jpa.JpaUnitRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UnitPersistence implements UnitRepository {

    private final JpaUnitRepository jpaUnitRepository;

    @Override
    public void save(Unit unit) {
        UnitDao unitDao = new UnitDao(unit);
        jpaUnitRepository.save(unitDao);
    }

    @Override
    public List<Unit> findAllByActiveTrue() {
        return jpaUnitRepository.findAllByActiveTrue()
                .stream()
                .map(UnitDao::toDomain)
                .toList();
    }

}
