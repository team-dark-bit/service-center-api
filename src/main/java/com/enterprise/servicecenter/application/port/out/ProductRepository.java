package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.application.model.Product;
import org.springframework.data.domain.Page;

public interface ProductRepository {
    void save(Product product);
    Product findById(String id);
    Page<Product> findAll(int page, int size);
}
