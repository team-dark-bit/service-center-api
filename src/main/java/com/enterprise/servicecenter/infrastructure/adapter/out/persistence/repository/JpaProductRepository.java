package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository;

import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.ProductDao;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductDao, String>, ProductRepositoryCustom {

}
