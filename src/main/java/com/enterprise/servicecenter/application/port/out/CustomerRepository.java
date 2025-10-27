package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.domain.model.Customer;
import java.util.List;

public interface CustomerRepository {
  void save(Customer customer);
  Customer findById(String id);
  List<Customer> findAllByActiveTrue();
}

