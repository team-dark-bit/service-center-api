package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.model.Product;
import com.enterprise.servicecenter.application.port.out.ProductRepository;
import com.enterprise.servicecenter.domain.model.ProductDao;
import com.enterprise.servicecenter.infrastructure.config.exception.ApplicationException;
import com.enterprise.servicecenter.infrastructure.repository.jpa.JpaProductRepository;
import org.springframework.stereotype.Repository;
import static com.enterprise.servicecenter.infrastructure.config.exception.RuntimeErrors.PRODUCT_NOT_FOUND;

@Repository
public class ProductPersistence implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    public ProductPersistence(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
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

}
