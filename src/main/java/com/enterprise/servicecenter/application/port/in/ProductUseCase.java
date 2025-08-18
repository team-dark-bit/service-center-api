package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateProductRequest;
import com.enterprise.servicecenter.application.dto.response.ProductResponse;

public interface ProductUseCase {
    void createProduct(CreateProductRequest createProductRequest);
    ProductResponse findById(String productId);
}
