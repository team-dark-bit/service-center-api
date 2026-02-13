package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository;

import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.InventoryBatchDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaInventoryBatchRepository extends JpaRepository<InventoryBatchDao, String> {
}
