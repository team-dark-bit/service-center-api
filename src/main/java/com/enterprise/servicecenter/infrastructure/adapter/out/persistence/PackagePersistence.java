package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.model.Package;
import com.enterprise.servicecenter.application.port.out.PackageRepository;
import com.enterprise.servicecenter.domain.model.PackageDao;
import com.enterprise.servicecenter.infrastructure.repository.jpa.JpaPackageRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PackagePersistence implements PackageRepository {

    private final JpaPackageRepository jpaPackageRepository;

    public PackagePersistence(JpaPackageRepository jpaPackageRepository) {
        this.jpaPackageRepository = jpaPackageRepository;
    }

    @Override
    public void save(Package pck) {
        PackageDao packageDao = new PackageDao(pck);
        jpaPackageRepository.save(packageDao);
    }
}
