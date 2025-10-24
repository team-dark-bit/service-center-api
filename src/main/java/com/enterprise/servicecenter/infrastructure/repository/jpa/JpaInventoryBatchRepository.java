package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.infrastructure.database.entity.InventoryBatchDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaInventoryBatchRepository extends JpaRepository<InventoryBatchDao, String> {
}
