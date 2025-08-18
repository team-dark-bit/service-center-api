package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.application.model.Product;

public interface ProductRepository {
    void save(Product product);
    Product findById(String id);
}
