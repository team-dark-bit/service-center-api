package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository;

import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.PurchaseDetailDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPurchaseDetailRepository extends JpaRepository<PurchaseDetailDao, String> {
}
