package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.domain.model.Service;
import java.util.List;

public interface ServiceRepository {
  void save(Service Service);
  List<Service> findAllByActiveTrue();
}
