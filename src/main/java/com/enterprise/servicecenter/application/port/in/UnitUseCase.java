package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateUnitRequest;
import com.enterprise.servicecenter.application.dto.response.UnitResponse;
import java.util.List;

public interface UnitUseCase {
    void createUnit(CreateUnitRequest createUnitRequest);
    List<UnitResponse> findAll();
}
