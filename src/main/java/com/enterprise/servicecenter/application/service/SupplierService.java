package com.enterprise.servicecenter.application.service;

import com.enterprise.servicecenter.application.dto.request.CreateSupplierRequest;
import com.enterprise.servicecenter.application.dto.response.SupplierResponse;
import com.enterprise.servicecenter.application.port.in.SupplierUseCase;
import com.enterprise.servicecenter.application.port.out.SupplierRepository;
import com.enterprise.servicecenter.application.service.mapper.SupplierRequestDomainMapper;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.mapper.dto.SupplierDomainResponseMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierService implements SupplierUseCase {

    private final SupplierRepository supplierRepository;
    private final SupplierRequestDomainMapper domainRequestMapper;
    private final SupplierDomainResponseMapper domainResponseMapper;

    @Override
    public void create(CreateSupplierRequest createSupplierRequest) {
        supplierRepository.save(domainRequestMapper.fromRequest(createSupplierRequest));
    }

    @Override
    public SupplierResponse findById(String supplierId) {
        return domainResponseMapper.toResponse(supplierRepository.findById(supplierId));
    }

    @Override
    public List<SupplierResponse> findAll() {
        return supplierRepository.findAllByActiveTrue()
                .stream()
                .map(domainResponseMapper::toResponse)
                .toList();
    }
}
