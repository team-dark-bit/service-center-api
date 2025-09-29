package com.enterprise.servicecenter.domain.specification;

import org.springframework.data.jpa.domain.Specification;
import com.enterprise.servicecenter.domain.model.ProductDao;

public class ProductSpecifications {
    public static Specification<ProductDao> search(String term) {
        return (root, query, cb) -> {
            String likeTerm = "%" + term.toLowerCase() + "%";
            return cb.or(
                    cb.like(cb.function("unaccent", String.class, cb.lower(root.get("name"))), likeTerm),
                    cb.like(cb.lower(root.get("displayName")), likeTerm),
                    cb.like(cb.lower(root.get("barcode")), likeTerm),
                    cb.like(cb.lower(root.get("sku")), likeTerm)
            );
        };
    }
}