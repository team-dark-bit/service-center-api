package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateProductRequest;
import com.enterprise.servicecenter.application.dto.response.ProductResponse;
import com.enterprise.servicecenter.application.model.Product;
import com.enterprise.servicecenter.application.model.ProductPackage;
import com.enterprise.servicecenter.application.port.in.ProductUseCase;
import com.enterprise.servicecenter.application.port.out.ProductPackageRepository;
import com.enterprise.servicecenter.application.port.out.ProductRepository;
import com.enterprise.servicecenter.common.util.DateUtil;
import com.enterprise.servicecenter.common.util.IdGenerator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {

  private final ProductRepository productRepository;
  private final ProductPackageRepository productPackageRepository;

  @Override
  public void createProduct(CreateProductRequest createProductRequest) {
    String productId = IdGenerator.generateId();
    productRepository.save(buildProduct(createProductRequest, productId));
    productPackageRepository.save(buildProductPackage(createProductRequest, productId));
  }

  @Override
  public ProductResponse findById(String productId) {
    return mapProductResponse(productRepository.findById(productId));
  }

  @Override
  public List<ProductResponse> findAll(String input, int pageNumber, int pageSize) {
    return productRepository.findAll(input, pageNumber, pageSize)
            .stream()
            .map(this::mapProductResponse)
            .toList();
  }

  private Product buildProduct(CreateProductRequest createProductRequest, String productId) {
    return Product.builder()
            .id(productId)
            .brandId(createProductRequest.getBrandId())
            .subcategoryId(createProductRequest.getSubcategoryId())
            .serviceCenterId(createProductRequest.getServiceCenterId())
            .name(createProductRequest.getName())
            .displayName(createProductRequest.getDisplayName())
            .description(createProductRequest.getDescription())
            .active(true)
            .activeFrom(DateUtil.toLocalDateTime(createProductRequest.getActiveFrom()))
            .barcode(createProductRequest.getBarcode())
            .sku(createProductRequest.getSku())
            .build();

  }

  private ProductPackage buildProductPackage(CreateProductRequest createProductRequest, String productId) {
    ProductPackage productPackage = new ProductPackage();
    productPackage.setId(IdGenerator.generateId());
    productPackage.setProductId(productId);
    productPackage.setPackageId(createProductRequest.getPackageId());
    productPackage.setUnitId(createProductRequest.getUnitId());
    productPackage.setQuantity(Double.parseDouble(createProductRequest.getQuantity()));
    productPackage.setCodedName(createProductRequest.getCodedName());
    productPackage.setImageUrl(createProductRequest.getImageUrl());
    productPackage.setStatus(createProductRequest.getStatus());

    return productPackage;
  }

  private ProductResponse mapProductResponse(Product product) {
    return ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            //.price(product.getPrice().toString())
            .build();
  }

}
