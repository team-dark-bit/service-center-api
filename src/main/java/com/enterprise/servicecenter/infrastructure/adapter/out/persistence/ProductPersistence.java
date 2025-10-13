package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.dto.response.ProductResponse;
import com.enterprise.servicecenter.application.port.out.ProductRepository;
import com.enterprise.servicecenter.domain.model.Product;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.projection.ProductProjectionResponseMapper;
import com.enterprise.servicecenter.infrastructure.config.exception.ApplicationException;
import com.enterprise.servicecenter.infrastructure.database.entity.ProductDao;
import com.enterprise.servicecenter.infrastructure.database.projection.ProductPackageProductProjection;
import com.enterprise.servicecenter.infrastructure.repository.jpa.JpaProductRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import static com.enterprise.servicecenter.infrastructure.config.exception.RuntimeErrors.PRODUCT_NOT_FOUND;

@Repository
public class ProductPersistence implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;
    private final ProductProjectionResponseMapper mapper;

    public ProductPersistence(JpaProductRepository jpaProductRepository,
                              ProductProjectionResponseMapper mapper) {
        this.jpaProductRepository = jpaProductRepository;
        this.mapper = mapper;
    }

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
    public List<ProductResponse> findAll(String input, int pageNumber, int pageSize) {
        List<ProductPackageProductProjection> projections = jpaProductRepository.searchProductsWithPackageTextPaged(input, pageNumber, pageSize);

        return projections.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

    }

}
