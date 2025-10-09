package com.enterprise.servicecenter.infrastructure.specification;

import org.springframework.data.jpa.domain.Specification;
import com.enterprise.servicecenter.infrastructure.database.entity.ProductDao;

public class ProductSpecifications {
    public static Specification<ProductDao> search(String term) {
        return (root, query, cb) -> {
            String likeTerm = "%" + unaccent(term.toLowerCase()) + "%";
            return cb.or(
                    cb.like(cb.function("unaccent", String.class, cb.lower(root.get("name"))), likeTerm),
                    cb.like(cb.lower(root.get("displayName")), likeTerm),
                    cb.like(cb.lower(root.get("barcode")), likeTerm),
                    cb.like(cb.lower(root.get("sku")), likeTerm)
            );
        };
    }

    public static String unaccent(String text) {
        return java.text.Normalizer.normalize(text, java.text.Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
    }
}