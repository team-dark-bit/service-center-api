package com.enterprise.servicecenter.infrastructure.adapter.out.persistence;

import com.enterprise.servicecenter.application.port.out.SupplierRepository;
import com.enterprise.servicecenter.domain.model.Supplier;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.domain.SupplierDaoDomainMapper;
import com.enterprise.servicecenter.infrastructure.config.exception.ApplicationException;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.JpaSupplierRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import static com.enterprise.servicecenter.infrastructure.config.exception.RuntimeErrors.SUPPLIER_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class SupplierPersistenceAdapter implements SupplierRepository {

  private final JpaSupplierRepository jpaSupplierRepository;
  private final SupplierDaoDomainMapper supplierDaoDomainMapper;

  @Override
  public void save(Supplier supplier) {
    jpaSupplierRepository.save(supplierDaoDomainMapper.toDao(supplier));
  }

  @Override
  public Supplier findById(String id) {
    return jpaSupplierRepository.findById(id)
            .map(supplierDaoDomainMapper::toDomain)
            .orElseThrow(() -> new ApplicationException(SUPPLIER_NOT_FOUND, id));
  }

  @Override
  public List<Supplier> findAllByActiveTrue() {
    return jpaSupplierRepository.findAllByActiveTrue()
            .stream()
            .map(supplierDaoDomainMapper::toDomain)
            .toList();
  }
}
