package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.port.out.SaleRepository;
import com.enterprise.servicecenter.domain.model.Sale;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain.SaleDaoDomainMapper;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.JpaSaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SalePersistenceAdapter implements SaleRepository {

  private final JpaSaleRepository jpaSaleRepository;
  private final SaleDaoDomainMapper saleDaoDomainMapper;

  @Override
  public void save(Sale sale) {
    jpaSaleRepository.save(saleDaoDomainMapper.toDao(sale));
  }
}
