package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateServiceRequest;
import com.enterprise.servicecenter.application.dto.response.ServiceResponse;
import java.util.List;

public interface ServiceUseCase {
  void createService(CreateServiceRequest createServiceRequest);
  List<ServiceResponse> findAll();
}
