package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateCustomerRequest;
import com.enterprise.servicecenter.application.dto.response.CustomerResponse;
import com.enterprise.servicecenter.application.port.in.CustomerUseCase;
import com.enterprise.servicecenter.application.port.out.CustomerRepository;
import com.enterprise.servicecenter.application.service.mapper.CustomerRequestDomainMapper;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.dto.CustomerDomainResponseMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerUseCase {

  private final CustomerRepository customerRepository;
  private final CustomerRequestDomainMapper domainRequestMapper;
  private final CustomerDomainResponseMapper domainResponseMapper;

  @Override
  public void create(CreateCustomerRequest createCustomerRequest) {
    customerRepository.save(domainRequestMapper.fromRequest(createCustomerRequest));
  }

  @Override
  public CustomerResponse findById(String customerId) {
    return domainResponseMapper.toResponse(customerRepository.findById(customerId));
  }

  @Override
  public List<CustomerResponse> findAll() {
    return customerRepository.findAllByActiveTrue()
            .stream()
            .map(domainResponseMapper::toResponse)
            .toList();
  }
}

