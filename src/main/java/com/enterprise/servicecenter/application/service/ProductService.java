package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateProductRequest;
import com.enterprise.servicecenter.application.dto.response.ProductResponse;
import com.enterprise.servicecenter.application.model.Product;
import com.enterprise.servicecenter.application.port.in.ProductUseCase;
import com.enterprise.servicecenter.application.port.out.ProductRepository;
import com.enterprise.servicecenter.common.util.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {

  private final ProductRepository productRepository;

  @Override
  public void createProduct(CreateProductRequest createProductRequest) {
    productRepository.save(buildProduct(createProductRequest));
  }

  @Override
  public ProductResponse findById(String productId) {
    return mapProductResponse(productRepository.findById(productId));
  }

  private Product buildProduct(CreateProductRequest createProductRequest) {
    Product product = new Product();
    product.setId(IdGenerator.generateId());
    product.setName(createProductRequest.getName());
    product.setDescription(createProductRequest.getDescription());
    product.setPrice(createProductRequest.getPrice());
    return product;
  }

  private ProductResponse mapProductResponse(Product product) {
    return ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice().toString())
            .build();
  }

}
