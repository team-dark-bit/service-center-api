package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.model.ProductPackage;
import com.enterprise.servicecenter.application.port.out.ProductPackageRepository;
import com.enterprise.servicecenter.domain.model.ProductPackageDao;
import com.enterprise.servicecenter.infrastructure.repository.jpa.JpaProductPackageRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductPackagePersistence implements ProductPackageRepository {

    private final JpaProductPackageRepository jpaProductPackageRepository;

    public ProductPackagePersistence(JpaProductPackageRepository jpaProductPackageRepository) {
        this.jpaProductPackageRepository = jpaProductPackageRepository;
    }

    @Override
    public void save(ProductPackage productPackage) {
        ProductPackageDao productPackageDao = new ProductPackageDao(productPackage);
        jpaProductPackageRepository.save(productPackageDao);
    }

    @Override
    public void saveAll(List<ProductPackage> productPackageList) {
        List<ProductPackageDao> daoList = productPackageList
                .stream()
                .map(ProductPackageDao::new)
                .toList();
        jpaProductPackageRepository.saveAll(daoList);
    }
}
