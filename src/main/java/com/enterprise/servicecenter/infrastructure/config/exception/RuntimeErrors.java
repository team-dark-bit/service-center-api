package com.enterprise.servicecenter.infrastructure.config.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
public enum RuntimeErrors implements ApplicationError {

    PRODUCT_NOT_FOUND(NOT_FOUND, "The product with id: %s does not exist"),
    BRAND_NOT_FOUND(NOT_FOUND, "The brand with id: %s does not exist"),
    SUPPLIER_NOT_FOUND(NOT_FOUND, "The supplier with id: %s does not exist"),
    CUSTOMER_NOT_FOUND(NOT_FOUND, "The customer with id: %s does not exist"),
    PRODUCT_WITHOUT_INVENTORY(BAD_REQUEST, "The product package with id %s does not have inventory"),
    PRODUCT_QUANTITY_EXCEEDS_INVENTORY(BAD_REQUEST, "The product package with id %s has only %d units available but %d were requested"),
    INVENTORY_BATCH_NOT_FOUND(NOT_FOUND, "The inventory batch with id: %s does not exist"),
    UPDATE_INVENTORY_ERROR(INTERNAL_SERVER_ERROR, "Error updating inventory");

    private final HttpStatus status;
    private final String message;

    @Override
    public HttpStatus getStatus() {
        return this.status;
    }

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
