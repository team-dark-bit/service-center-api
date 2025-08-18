package com.enterprise.servicecenter.common.util.validation;

import com.enterprise.servicecenter.common.util.validation.annotation.IsDecimal;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsDecimalValidator implements ConstraintValidator<IsDecimal, String> {

  private int numbers;
  private int decimals;

  @Override
  public void initialize(IsDecimal constraintAnnotation) {
    this.numbers = constraintAnnotation.numbers();
    this.decimals = constraintAnnotation.decimals();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    String regex = "^\\d{1," + numbers + "}\\.\\d{1," + decimals + "}$";
    return value.matches(regex);
  }
}