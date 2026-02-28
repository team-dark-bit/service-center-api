package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateServiceRequest;

public interface ServiceUseCase {
  void createService(CreateServiceRequest createServiceRequest);
}
