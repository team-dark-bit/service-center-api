package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateUnitRequest;

public interface UnitUseCase {
    void createUnit(CreateUnitRequest createUnitRequest);
}
