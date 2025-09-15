package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.application.model.Package;

public interface PackageRepository {
    void save(Package pck);
}
