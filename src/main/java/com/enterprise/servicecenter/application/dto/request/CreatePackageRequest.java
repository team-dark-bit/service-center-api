package com.enterprise.servicecenter.application.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreatePackageRequest {
    private String name;
    private String code;
}
