package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.port.out.SupplierRepository;
import com.enterprise.servicecenter.domain.model.Supplier;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain.SupplierDaoDomainMapper;
import com.enterprise.servicecenter.infrastructure.repository.jpa.JpaSupplierRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class SupplierPersistence implements SupplierRepository {

  private final JpaSupplierRepository jpaSupplierRepository;
  private final SupplierDaoDomainMapper supplierDaoDomainMapper;

  public SupplierPersistence(JpaSupplierRepository jpaSupplierRepository,
                             SupplierDaoDomainMapper supplierDaoDomainMapper) {
    this.jpaSupplierRepository = jpaSupplierRepository;
      this.supplierDaoDomainMapper = supplierDaoDomainMapper;
  }

  @Override
  public void save(Supplier supplier) {
    jpaSupplierRepository.save(supplierDaoDomainMapper.toDao(supplier));
  }

  @Override
  public Supplier findById(String id) {
    return null;
  }

  @Override
  public List<Supplier> findAllByActiveTrue() {
    return List.of();
  }
}
