package com.enterprise.servicecenter.infrastructure.config.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RequiredArgsConstructor
public enum ValidationErrors implements ApplicationError {

  DECIMAL_BAD_REQUEST(BAD_REQUEST, "Invalid decimal format"),
  FIELD_REQUIRED(BAD_REQUEST, "The field %s must not be null or empty"),
  PRODUCT_WITHOUT_INVENTORY(BAD_REQUEST, "The product package with id %s does not have inventory"),
  PRODUCT_QUANTITY_EXCEEDS_INVENTORY(BAD_REQUEST, "The product package with id %s has only %d units available but %d were requested");


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
