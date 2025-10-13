package com.enterprise.servicecenter.application.port.in;

import com.enterprise.servicecenter.application.dto.request.CreateSupplierRequest;
import com.enterprise.servicecenter.application.dto.response.SupplierResponse;
import java.util.List;

public interface SupplierUseCase {
  void create(CreateSupplierRequest createSupplierRequest);
  SupplierResponse findById(String supplierId);
  List<SupplierResponse> findAll();
}