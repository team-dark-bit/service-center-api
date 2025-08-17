package com.enterprise.servicecenter.com.anthares.application.port.out;

import com.enterprise.servicecenter.application.model.Product;

public interface ProductRepository {
    void save(Product product);
}
