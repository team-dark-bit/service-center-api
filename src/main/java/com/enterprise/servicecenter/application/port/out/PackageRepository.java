package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.application.model.Package;
import java.util.List;

public interface PackageRepository {
    void save(Package pck);
    List<Package> findAllByActiveTrue();
}
