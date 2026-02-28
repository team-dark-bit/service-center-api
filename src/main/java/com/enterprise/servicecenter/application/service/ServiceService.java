package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateServiceRequest;
import com.enterprise.servicecenter.application.dto.response.ServiceResponse;
import com.enterprise.servicecenter.application.port.in.ServiceUseCase;
import com.enterprise.servicecenter.application.port.out.ServiceRepository;
import com.enterprise.servicecenter.application.service.mapper.ServiceRequestDomainMapper;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.dto.ServiceDomainResponseMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceService implements ServiceUseCase {

  private final ServiceRepository serviceRepository;
  private final ServiceRequestDomainMapper serviceRequestDomainMapper;
  private final ServiceDomainResponseMapper serviceDomainResponseMapper;

  @Override
  public void createService(CreateServiceRequest createServiceRequest) {
    serviceRepository.save(serviceRequestDomainMapper.fromRequest(createServiceRequest));
  }

  @Override
  public List<ServiceResponse> findAll() {
    return serviceRepository.findAllByActiveTrue()
            .stream()
            .map(serviceDomainResponseMapper::toResponse)
            .toList();
  }
}
