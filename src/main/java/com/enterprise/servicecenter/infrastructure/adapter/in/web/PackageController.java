package com.enterprise.servicecenter.infrastructure.adapter.in.web;

import com.enterprise.servicecenter.application.dto.request.CreatePackageRequest;
import com.enterprise.servicecenter.application.dto.response.PackageResponse;
import com.enterprise.servicecenter.application.port.in.PackageUseCase;
import com.enterprise.servicecenter.common.response.ApiResponse;
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
@RequestMapping("/packages")
@Slf4j
@Validated
public class PackageController {

    private final PackageUseCase packageUseCase;

    public PackageController(PackageUseCase packageUseCase) {
        this.packageUseCase = packageUseCase;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createPackage(
            @RequestBody
            @Valid
            CreatePackageRequest request
    ) {
        packageUseCase.createPackage(request);
        return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED.value(), "Package created successfully", null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PackageResponse>>> findAll() {
        List<PackageResponse> packages = packageUseCase.findAll();
        return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "Packages found", packages));
    }
}
