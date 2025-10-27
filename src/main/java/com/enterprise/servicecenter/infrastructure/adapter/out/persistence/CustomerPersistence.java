package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.port.out.CustomerRepository;
import com.enterprise.servicecenter.domain.model.Customer;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain.CustomerDaoDomainMapper;
import com.enterprise.servicecenter.infrastructure.config.exception.ApplicationException;
import com.enterprise.servicecenter.infrastructure.repository.jpa.JpaCustomerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.enterprise.servicecenter.infrastructure.config.exception.RuntimeErrors.CUSTOMER_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class CustomerPersistence implements CustomerRepository {

  private final JpaCustomerRepository jpaCustomerRepository;
  private final CustomerDaoDomainMapper customerDaoDomainMapper;

  @Override
  public void save(Customer customer) {
    jpaCustomerRepository.save(customerDaoDomainMapper.toDao(customer));
  }

  @Override
  public Customer findById(String id) {
    return jpaCustomerRepository.findById(id)
            .map(customerDaoDomainMapper::toDomain)
            .orElseThrow(() -> new ApplicationException(CUSTOMER_NOT_FOUND, id));
  }

  @Override
  public List<Customer> findAllByActiveTrue() {
    return jpaCustomerRepository.findAllByActiveTrue()
            .stream()
            .map(customerDaoDomainMapper::toDomain)
            .toList();
  }
}

