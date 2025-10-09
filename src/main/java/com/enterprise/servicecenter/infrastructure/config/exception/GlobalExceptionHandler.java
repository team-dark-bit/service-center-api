package com.enterprise.servicecenter.infrastructure.config.exception;

import com.enterprise.servicecenter.commons.response.ApiResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ApiResponse<Void>> handleCustomException(ApplicationException ex) {
      List<String> errors = List.of(ex.getMessage());
      ApiResponse<Void> response = ApiResponse.failure(ex.getStatus().value(), "A problem occurred", errors);
      return new ResponseEntity<>(response, ex.getStatus());
    }

}
