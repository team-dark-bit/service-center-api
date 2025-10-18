package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.infrastructure.database.entity.PurchaseDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPurchaseRepository extends JpaRepository<PurchaseDao, String> {
}
