package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateProductRequest;
import com.enterprise.servicecenter.application.dto.response.ProductResponse;
import org.springframework.data.domain.Page;

public interface ProductUseCase {
    void createProduct(CreateProductRequest createProductRequest);
    ProductResponse findById(String productId);
    Page<ProductResponse> findAll(int page, int size);
}
