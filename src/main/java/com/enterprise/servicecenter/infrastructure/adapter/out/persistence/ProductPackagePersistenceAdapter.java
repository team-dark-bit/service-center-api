package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.domain.model.ProductPackage;
import com.enterprise.servicecenter.application.port.out.ProductPackageRepository;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.ProductPackageDao;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.JpaProductPackageRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductPackagePersistenceAdapter implements ProductPackageRepository {

    private final JpaProductPackageRepository jpaProductPackageRepository;

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
