package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateSupplierRequest;
import com.enterprise.servicecenter.application.dto.response.SupplierResponse;
import com.enterprise.servicecenter.application.port.in.SupplierUseCase;
import com.enterprise.servicecenter.application.port.out.SupplierRepository;
import com.enterprise.servicecenter.application.service.mapper.SupplierRequestDomainMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierService implements SupplierUseCase {

    private final SupplierRepository supplierRepository;
    private final SupplierRequestDomainMapper domainMapper;

    @Override
    public void create(CreateSupplierRequest createSupplierRequest) {
        supplierRepository.save(domainMapper.fromRequest(createSupplierRequest));
    }

    @Override
    public SupplierResponse findById(String supplierId) {
        return null;
    }

    @Override
    public List<SupplierResponse> findAll() {
        return List.of();
    }
}
