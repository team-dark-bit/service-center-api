package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.infrastructure.database.entity.PurchaseDetailDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPurchaseDetailRepository extends JpaRepository<PurchaseDetailDao, String> {
}
