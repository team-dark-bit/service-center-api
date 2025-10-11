package com.enterprise.servicecenter.infrastructure.repository.jpa;

import com.enterprise.servicecenter.infrastructure.database.entity.ProductDao;
import com.enterprise.servicecenter.infrastructure.database.entity.ProductPackageDao;
import com.enterprise.servicecenter.infrastructure.database.projection.ProductPackageProductProjection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProductPackageProductProjection> searchProductsWithPackageTextPaged(String text, int page, int size) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductPackageProductProjection> cq = cb.createQuery(ProductPackageProductProjection.class);

        Root<ProductDao> productRoot = cq.from(ProductDao.class);
        Root<ProductPackageDao> packageRoot = cq.from(ProductPackageDao.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(productRoot.get("id"), packageRoot.get("productId")));

        if (text != null && !text.isEmpty()) {
            String pattern = "%" + text.toLowerCase() + "%";
            Predicate namePredicate = cb.like(cb.lower(productRoot.get("name")), pattern);
            Predicate skuPredicate = cb.like(cb.lower(packageRoot.get("sku")), pattern);
            Predicate barcodePredicate = cb.like(cb.lower(packageRoot.get("barcode")), pattern);
            predicates.add(cb.or(namePredicate, skuPredicate, barcodePredicate));
        }

        cq.select(cb.construct(
                ProductPackageProductProjection.class,
                productRoot.get("id"),
                productRoot.get("name"),
                packageRoot.get("sku"),
                packageRoot.get("barcode")
        )).where(predicates.toArray(new Predicate[0]));

        // Opcional: Agregar orden
        cq.orderBy(cb.asc(productRoot.get("name")));

        // Crear la query
        var query = entityManager.createQuery(cq);
        query.setFirstResult(page * size); // page 0-based
        query.setMaxResults(size);

        return query.getResultList();
    }
}