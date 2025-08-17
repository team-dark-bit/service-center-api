package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.ProductRequest;

public interface CreateProductUseCase {
    void createProduct(ProductRequest productRequest);
}
