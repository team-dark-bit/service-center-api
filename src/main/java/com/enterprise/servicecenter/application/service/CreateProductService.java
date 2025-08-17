package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.ProductRequest;
import com.enterprise.servicecenter.application.model.Product;
import com.enterprise.servicecenter.application.port.in.CreateProductUseCase;
import com.enterprise.servicecenter.com.anthares.application.port.out.ProductRepository;
import com.enterprise.servicecenter.common.util.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductService implements CreateProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductRequest productRequest) {
        productRepository.save(buildProduct(productRequest));
    }

    private Product buildProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setId(IdGenerator.generateId());
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());

        return product;
    }

}
