package com.enterprise.servicecenter.infrastructure.adapter.in.web;

import com.enterprise.servicecenter.application.dto.request.CreatePurchaseRequest;
import com.enterprise.servicecenter.application.service.PurchaseService;
import com.enterprise.servicecenter.commons.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchases")
@Validated
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Void>>  createPurchase(@Valid @RequestBody CreatePurchaseRequest request) {
        purchaseService.create(request);
        return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED.value(),
                "Purchase created successfully", null));
    }

}
