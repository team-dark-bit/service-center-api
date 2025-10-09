package com.enterprise.servicecenter.infrastructure.adapter.in.web;

import com.enterprise.servicecenter.application.dto.request.CreateUnitRequest;
import com.enterprise.servicecenter.application.dto.response.UnitResponse;
import com.enterprise.servicecenter.application.port.in.UnitUseCase;
import com.enterprise.servicecenter.commons.response.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/units")
@Slf4j
@Validated
public class UnitController {

    private final UnitUseCase unitUseCase;

    public UnitController(UnitUseCase unitUseCase) {
        this.unitUseCase = unitUseCase;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createUnit(
            @RequestBody
            @Valid
            CreateUnitRequest request
    ) {
        unitUseCase.createUnit(request);
        return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED.value(), "Unit created successfully", null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UnitResponse>>> findAll() {
        List<UnitResponse> units = unitUseCase.findAll();
        return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "Units found", units));
    }

}
