package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateUnitRequest;
import com.enterprise.servicecenter.application.dto.response.UnitResponse;
import com.enterprise.servicecenter.application.model.Unit;
import com.enterprise.servicecenter.application.port.in.UnitUseCase;
import com.enterprise.servicecenter.application.port.out.UnitRepository;
import com.enterprise.servicecenter.common.util.IdGenerator;
import java.util.List;
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

    @Override
    public List<UnitResponse> findAll() {
        return unitRepository.findAllByActiveTrue()
                .stream()
                .map(this::buildUnitResponse)
                .toList();
    }

    private Unit buildUnit(CreateUnitRequest createUnitRequest) {
        Unit unit = new Unit();
        unit.setId(IdGenerator.generateId());
        unit.setName(createUnitRequest.getName());
        unit.setCode(createUnitRequest.getCode());
        return unit;
    }

    private UnitResponse buildUnitResponse(Unit unit) {
        return UnitResponse.builder()
                .id(unit.getId())
                .name(unit.getName())
                .code(unit.getCode())
                .build();
    }
}
