package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.domain.model.Package;
import java.util.List;

public interface PackageRepository {
    void save(Package pck);
    List<Package> findAllByActiveTrue();
}
