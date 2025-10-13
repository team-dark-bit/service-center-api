package com.enterprise.servicecenter.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Supplier {

    private String id;
    private String name;
    private String documentType;
    private String documentNumber;
    private String description;
    private String address;
    private String phone;
    private String email;
    private boolean active;
}