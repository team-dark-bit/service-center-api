package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.domain.model.Service;

public interface ServiceRepository {
  void save(Service Service);
}
