package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.application.model.Product;
import java.util.List;

public interface ProductRepository {
    void save(Product product);
    Product findById(String id);
    List<Product> findAll(String input, int pageNumber, int pageSize);
}
