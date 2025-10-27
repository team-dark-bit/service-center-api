package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateCustomerRequest;
import com.enterprise.servicecenter.application.dto.response.CustomerResponse;
import java.util.List;

public interface CustomerUseCase {
  void create(CreateCustomerRequest createCustomerRequest);
  CustomerResponse findById(String customerId);
  List<CustomerResponse> findAll();
}

