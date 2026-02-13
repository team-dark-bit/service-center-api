package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.domain.model.Package;
import com.enterprise.servicecenter.application.port.out.PackageRepository;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.PackageDao;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.JpaPackageRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PackagePersistenceAdapter implements PackageRepository {

    private final JpaPackageRepository jpaPackageRepository;

    @Override
    public void save(Package pck) {
        PackageDao packageDao = new PackageDao(pck);
        jpaPackageRepository.save(packageDao);
    }

    @Override
    public List<Package> findAllByActiveTrue() {
        return jpaPackageRepository.findAllByActiveTrue()
                .stream()
                .map(PackageDao::toDomain)
                .toList();
    }
}
