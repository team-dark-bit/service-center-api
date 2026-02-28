package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.port.out.ServiceRepository;
import com.enterprise.servicecenter.domain.model.Service;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain.ServiceDaoDomainMapper;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.JpaServiceRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ServicePersistenceAdapter implements ServiceRepository {

  private final JpaServiceRepository jpaServiceRepository;
  private final ServiceDaoDomainMapper serviceDaoDomainMapper;

  @Override
  public void save(Service service) {
    jpaServiceRepository.save(serviceDaoDomainMapper.toDao(service));
  }

  @Override
  public List<Service> findAllByActiveTrue() {
    return jpaServiceRepository.findAllByActiveTrue()
            .stream()
            .map(serviceDaoDomainMapper::toDomain)
            .toList();
  }
}
