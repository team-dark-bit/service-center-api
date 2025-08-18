package com.enterprise.servicecenter.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    private String id;
    private String name;
    private String description;
    private Double price;

    public void setPrice(String price) {
        this.price = Double.parseDouble(price);
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
