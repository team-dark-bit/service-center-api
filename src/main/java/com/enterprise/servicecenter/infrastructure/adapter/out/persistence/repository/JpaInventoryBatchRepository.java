package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository;

import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.InventoryBatchDao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaInventoryBatchRepository extends JpaRepository<InventoryBatchDao, String> {

  @Query("SELECT DISTINCT ib.productPackageId FROM InventoryBatch ib WHERE ib.productPackageId IN :ids")
  List<String> findExistingProductPackageIds(@Param("ids") List<String> ids);
}