package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.response.product.ProductCatalogResponse;
import com.enterprise.servicecenter.application.port.in.ProductQueryUseCase;
import com.enterprise.servicecenter.application.port.out.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductQueryService implements ProductQueryUseCase {

  private final ProductRepository productRepository;

  @Override
  public List<ProductCatalogResponse> listForCatalog(String input, int pageNumber, int pageSize) {
    return productRepository.searchProductsForCatalog(input, pageNumber, pageSize);
  }
}
