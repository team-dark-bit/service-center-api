package com.enterprise.servicecenter.application.port.out;

import com.enterprise.servicecenter.domain.model.Supplier;
import java.util.List;

public interface SupplierRepository {
  void save(Supplier supplier);
  Supplier findById(String id);
  List<Supplier> findAllByActiveTrue();
}
