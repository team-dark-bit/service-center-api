package com.enterprise.servicecenter.infrastructure.repository.custom;

import com.enterprise.servicecenter.infrastructure.database.entity.ProductDao;
import com.enterprise.servicecenter.infrastructure.database.entity.ProductPackageDao;
import com.enterprise.servicecenter.infrastructure.database.entity.CategoryDao;
import com.enterprise.servicecenter.infrastructure.database.entity.PurchaseDetailDao;
import com.enterprise.servicecenter.infrastructure.database.entity.SubcategoryDao;
import com.enterprise.servicecenter.infrastructure.database.entity.BrandDao;
import com.enterprise.servicecenter.infrastructure.database.projection.ProductForCatalogProjection;
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
        Root<ProductPackageDao> productPackageRoot = cq.from(ProductPackageDao.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(productRoot.get("id"), productPackageRoot.get("productId")));

        if (text != null && !text.isEmpty()) {
            String pattern = "%" + text.toLowerCase() + "%";
            Predicate namePredicate = cb.like(cb.lower(productRoot.get("name")), pattern);
            Predicate skuPredicate = cb.like(cb.lower(productPackageRoot.get("sku")), pattern);
            Predicate barcodePredicate = cb.like(cb.lower(productPackageRoot.get("barcode")), pattern);
            predicates.add(cb.or(namePredicate, skuPredicate, barcodePredicate));
        }

        cq.select(cb.construct(
                ProductPackageProductProjection.class,
                productRoot.get("id"),
                productPackageRoot.get("id"),
                productRoot.get("name"),
                productPackageRoot.get("codedName"),
                productPackageRoot.get("sku"),
                productPackageRoot.get("barcode")
        )).where(predicates.toArray(new Predicate[0]));

        // Opcional: Agregar orden
        cq.orderBy(cb.asc(productRoot.get("name")));

        // Crear la query
        var query = entityManager.createQuery(cq);
        query.setFirstResult(page * size); // page 0-based
        query.setMaxResults(size);

        return query.getResultList();
    }

    @Override
    public List<ProductForCatalogProjection> searchProductsForCatalog(
            String text, int page, int size) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductForCatalogProjection> cq = cb.createQuery(ProductForCatalogProjection.class);

        Root<ProductDao> productRoot = cq.from(ProductDao.class);
        Root<ProductPackageDao> productPackageRoot = cq.from(ProductPackageDao.class);
        Root<BrandDao> brandRoot = cq.from(BrandDao.class);
        Root<CategoryDao> categoryRoot = cq.from(CategoryDao.class);
        Root<SubcategoryDao> subcategoryRoot = cq.from(SubcategoryDao.class);
        Root<PurchaseDetailDao> purchaseDetailDaoRoot = cq.from(PurchaseDetailDao.class);

        List<Predicate> predicates = new ArrayList<>();
        // joins
        predicates.add(cb.equal(productRoot.get("id"), productPackageRoot.get("productId")));
        predicates.add(cb.equal(productRoot.get("brandId"), brandRoot.get("id")));
        predicates.add(cb.equal(productRoot.get("subcategoryId"), subcategoryRoot.get("id")));
        predicates.add(cb.equal(subcategoryRoot.get("categoryId"), categoryRoot.get("id")));
        predicates.add(cb.equal(productPackageRoot.get("id"), purchaseDetailDaoRoot.get("productPackageId")));

        if (text != null && !text.isEmpty()) {
            String pattern = "%" + text.toLowerCase() + "%";
            Predicate namePredicate = cb.like(cb.lower(productRoot.get("name")), pattern);
            Predicate skuPredicate = cb.like(cb.lower(productPackageRoot.get("sku")), pattern);
            Predicate barcodePredicate = cb.like(cb.lower(productPackageRoot.get("barcode")), pattern);
            Predicate brandPredicate = cb.like(cb.lower(brandRoot.get("name")), pattern);
            Predicate categoryPredicate = cb.like(cb.lower(categoryRoot.get("name")), pattern);
            Predicate subcategoryPredicate = cb.like(cb.lower(subcategoryRoot.get("name")), pattern);

            predicates.add(cb.or(
                    namePredicate,
                    skuPredicate,
                    barcodePredicate,
                    brandPredicate,
                    categoryPredicate,
                    subcategoryPredicate
            ));
        }

        cq.select(cb.construct(
                ProductForCatalogProjection.class,
                productRoot.get("id"),
                productPackageRoot.get("id"),
                productRoot.get("name"),
                productPackageRoot.get("codedName"),
                productPackageRoot.get("sku"),
                productPackageRoot.get("barcode"),
                purchaseDetailDaoRoot.get("saleUnitPrice"),
                cb.literal(0),
                productPackageRoot.get("imageUrl"),
                brandRoot.get("name"),
                categoryRoot.get("name"),
                subcategoryRoot.get("name")
        )).where(predicates.toArray(new Predicate[0]));

        cq.orderBy(cb.asc(productRoot.get("name")));

        var query = entityManager.createQuery(cq);
        query.setFirstResult(page * size);
        query.setMaxResults(size);

        return query.getResultList();
    }
}