package com.enterprise.servicecenter.domain.model;

import com.enterprise.servicecenter.application.model.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Product")
@Table(name = "products")
public class ProductDao {

    @Id
    private String id;

    private String name;
    private String description;

    protected ProductDao() {
    }

    public ProductDao(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
    }

    public Product toDomain() {
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setDescription(this.description);
        return product;
    }

}
