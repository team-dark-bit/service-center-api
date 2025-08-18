package com.enterprise.servicecenter.infrastructure.config.exception;

import org.springframework.http.HttpStatus;

public interface ApplicationError {

    HttpStatus getStatus();
    String getCode();
    String getMessage();

}
