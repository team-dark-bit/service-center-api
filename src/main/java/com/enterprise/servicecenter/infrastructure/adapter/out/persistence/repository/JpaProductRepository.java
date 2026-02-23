package com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository;

import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.entity.ProductDao;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.projection.InventoryBatchProjection;
import com.enterprise.servicecenter.infrastructure.adapter.out.persistence.repository.custom.ProductRepositoryCustom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaProductRepository extends JpaRepository<ProductDao, String>, ProductRepositoryCustom {
  @Query(value = """
          SELECT
            p.id                     AS purchaseId,
            p.purchase_number        AS purchaseNumber,
            pd.purchase_unit_price   AS purchaseUnitPrice,
            pd.sale_unit_price       AS saleUnitPrice,
            ib.quantity_available    AS quantityAvailable,
            p.purchase_date          AS purchaseDate
          FROM purchases p
          JOIN purchase_details pd ON p.id = pd.purchase_id
          JOIN inventory_batches ib ON p.id = ib.purchase_id
            AND pd.product_package_id = ib.product_package_id
          WHERE ib.quantity_available > 0
            AND pd.product_package_id = :productPackageId
          ORDER BY p.purchase_date ASC
          """,
          nativeQuery = true)
  List<InventoryBatchProjection> findByProductPackageId(@Param("productPackageId") String productPackageId);
}
