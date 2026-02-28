package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateServiceRequest;
import com.enterprise.servicecenter.application.port.in.ServiceUseCase;
import com.enterprise.servicecenter.application.port.out.ServiceRepository;
import com.enterprise.servicecenter.application.service.mapper.ServiceRequestDomainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceService implements ServiceUseCase {

  private final ServiceRepository serviceRepository;
  private final ServiceRequestDomainMapper serviceRequestDomainMapper;

  @Override
  public void createService(CreateServiceRequest createServiceRequest) {
    serviceRepository.save(serviceRequestDomainMapper.fromRequest(createServiceRequest));
  }
}
