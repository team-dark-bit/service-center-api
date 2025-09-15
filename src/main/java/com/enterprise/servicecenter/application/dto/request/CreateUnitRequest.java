package com.enterprise.servicecenter.application.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateUnitRequest {
    private String name;
    private String code;
}
