package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.model.Product;
import com.enterprise.servicecenter.application.port.out.ProductRepository;
import com.enterprise.servicecenter.domain.model.ProductDao;
import com.enterprise.servicecenter.infrastructure.repository.jpa.JpaProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryPersistence implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    public ProductRepositoryPersistence(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public void save(Product product) {
        ProductDao productDao = new ProductDao(product);
        jpaProductRepository.save(productDao);
    }
}
