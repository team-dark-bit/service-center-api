package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.dto.response.product.ProductPurchaseResponse;
import com.enterprise.servicecenter.application.dto.response.product.catalog.ProductCatalogResponse;
import com.enterprise.servicecenter.application.port.out.ProductRepository;
import com.enterprise.servicecenter.domain.model.Product;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.ProductDao;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.projection.ProductCatalogProjectionResponseMapper;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.projection.ProductInventoryProjectionResponseMapper;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.projection.ProductProjectionResponseMapper;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection.ProductForCatalogProjection;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection.ProductForPurchaseProjection;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.JpaProductRepository;
import com.enterprise.servicecenter.infrastructure.config.exception.ApplicationException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import static com.enterprise.servicecenter.infrastructure.config.exception.RuntimeErrors.PRODUCT_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductRepository {

  private final JpaProductRepository jpaProductRepository;
  private final ProductProjectionResponseMapper productProjectRespMapper;
  private final ProductCatalogProjectionResponseMapper productCatalogProjectRespMapper;
  private final ProductInventoryProjectionResponseMapper productInventoryProjectRespMapper;

  @Override
  public void save(Product product) {
    ProductDao productDao = new ProductDao(product);
    jpaProductRepository.save(productDao);
  }

  @Override
  public Product findById(String id) {
    return jpaProductRepository.findById(id)
            .map(ProductDao::toDomain)
            .orElseThrow(() -> new ApplicationException(PRODUCT_NOT_FOUND, id));
  }

  @Override
  public List<ProductPurchaseResponse> searchProductsForPurchase(String input, int pageNumber, int pageSize) {
    List<ProductForPurchaseProjection> projections =
            jpaProductRepository.searchProductsForPurchase(input, pageNumber, pageSize);

    return projections.stream()
            .map(productProjectRespMapper::toResponse)
            .toList();
  }

  @Override
  public List<ProductCatalogResponse> searchProductsForCatalog(
          String input, int pageNumber, int pageSize) {
    List<ProductForCatalogProjection> projections =
            jpaProductRepository.searchProductsForCatalog(input, pageNumber, pageSize);
    return productCatalogProjectRespMapper.toResponses(projections);
  }

}
