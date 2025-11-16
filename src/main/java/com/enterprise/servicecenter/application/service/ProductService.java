package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateProductPackageRequest;
import com.enterprise.servicecenter.application.dto.request.CreateProductRequest;
import com.enterprise.servicecenter.application.dto.response.ProductResponse;
import com.enterprise.servicecenter.application.port.in.ProductUseCase;
import com.enterprise.servicecenter.application.port.out.ProductPackageRepository;
import com.enterprise.servicecenter.application.port.out.ProductRepository;
import com.enterprise.servicecenter.commons.util.DateUtil;
import com.enterprise.servicecenter.commons.util.IdGenerator;
import com.enterprise.servicecenter.domain.model.Product;
import com.enterprise.servicecenter.domain.model.ProductPackage;
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
    productPackageRepository.saveAll(buildProductPackage(createProductRequest.getPackages(), productId));
  }

  @Override
  public ProductResponse findById(String productId) {
    return mapProductResponse(productRepository.findById(productId));
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
            .build();

  }

  private List<ProductPackage> buildProductPackage(List<CreateProductPackageRequest> productPackageRequests,
                                                   String productId) {

    return productPackageRequests.stream()
            .map(productPackageRequest -> {
              ProductPackage productPackage = new ProductPackage();
              productPackage.setId(IdGenerator.generateId());
              productPackage.setProductId(productId);
              productPackage.setPackageId(productPackageRequest.getPackageId());
              productPackage.setUnitId(productPackageRequest.getUnitId());
              productPackage.setQuantity(Double.parseDouble(productPackageRequest.getQuantity()));
              productPackage.setCodedName(productPackageRequest.getCodedName());
              productPackage.setImageUrl(productPackageRequest.getImageUrl());
              productPackage.setStatus(productPackageRequest.getStatus());
              productPackage.setBarcode(productPackageRequest.getBarcode());
              productPackage.setSku(productPackageRequest.getSku());
              productPackage.setDescription(productPackageRequest.getDescription());
              return productPackage;
            })
            .toList();
  }

  private ProductResponse mapProductResponse(Product product) {
    return ProductResponse.builder()
            .productId(product.getId())
            .productName(product.getName())
            .build();
  }

}
