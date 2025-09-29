package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateProductRequest;
import com.enterprise.servicecenter.application.dto.response.ProductResponse;
import java.util.List;

public interface ProductUseCase {
    void createProduct(CreateProductRequest createProductRequest);
    ProductResponse findById(String productId);
    List<ProductResponse> findAll(String input, int pageNumber, int pageSize);
}
