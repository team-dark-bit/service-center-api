package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.application.dto.response.ProductResponse;
import com.enterprise.servicecenter.domain.model.Product;
import java.util.List;

public interface ProductRepository {
    void save(Product product);
    Product findById(String id);
    List<ProductResponse> findAll(String input, int pageNumber, int pageSize);
}
