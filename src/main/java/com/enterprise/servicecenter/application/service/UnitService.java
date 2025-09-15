package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateUnitRequest;
import com.enterprise.servicecenter.application.model.Unit;
import com.enterprise.servicecenter.application.port.in.UnitUseCase;
import com.enterprise.servicecenter.application.port.out.UnitRepository;
import com.enterprise.servicecenter.common.util.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnitService implements UnitUseCase {

    private final UnitRepository unitRepository;

    @Override
    public void createUnit(CreateUnitRequest createUnitRequest) {
        unitRepository.save(buildUnit(createUnitRequest));
    }

    private Unit buildUnit(CreateUnitRequest createUnitRequest) {
        Unit unit = new Unit();
        unit.setId(IdGenerator.generateId());
        unit.setName(createUnitRequest.getName());
        unit.setCode(createUnitRequest.getCode());
        return unit;
    }
}
