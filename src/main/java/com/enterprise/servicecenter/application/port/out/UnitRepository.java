package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.domain.model.Unit;
import java.util.List;

public interface UnitRepository {
    void save(Unit unit);
    List<Unit> findAllByActiveTrue();
}
