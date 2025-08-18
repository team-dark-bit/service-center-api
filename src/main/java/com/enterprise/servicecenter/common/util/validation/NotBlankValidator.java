package com.enterprise.servicecenter.common.util.validation;

import com.enterprise.servicecenter.common.util.validation.annotation.NotBlank;
import com.enterprise.servicecenter.infrastructure.config.exception.ApplicationException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import static com.enterprise.servicecenter.infrastructure.config.exception.ValidationErrors.FIELD_REQUIRED;

public class NotBlankValidator implements ConstraintValidator<NotBlank, String> {

  private String name;

  @Override
  public void initialize(NotBlank constraintAnnotation) {
    this.name = constraintAnnotation.name();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    if (StringUtils.isBlank(value)) {
      throw new ApplicationException(FIELD_REQUIRED, name);
    }
    return true;
  }
}
