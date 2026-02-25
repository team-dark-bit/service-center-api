package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository;

import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.PurchaseDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPurchaseRepository extends JpaRepository<PurchaseDao, String> {

}
