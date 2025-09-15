package com.enterprise.servicecenter.domain.model;

import com.enterprise.servicecenter.application.model.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Product")
@Table(name = "products")
public class ProductDao {

    @Id
    private String id;

    private String brandId;
    private String subcategoryId;
    private String serviceCenterId;
    private String name;
    private String displayName;
    private String description;
    private Boolean active;
    private LocalDateTime activeFrom;
    private LocalDateTime activeTo;
    private String barcode;
    private String sku;


    protected ProductDao() {
    }

    public ProductDao(Product product) {
        this.id = product.getId();
        this.brandId = product.getBrandId();
        this.subcategoryId = product.getSubcategoryId();
        this.serviceCenterId = product.getServiceCenterId();
        this.name = product.getName();
        this.displayName = product.getDisplayName();
        this.description = product.getDescription();
        this.active = product.getActive();
        this.activeFrom = product.getActiveFrom();
        this.activeTo = product.getActiveTo();
        this.barcode = product.getBarcode();
        this.sku = product.getSku();
    }

    public Product toDomain() {
        Product product = new Product();
        product.setId(this.id);
        product.setBrandId(this.brandId);
        product.setSubcategoryId(this.subcategoryId);
        product.setServiceCenterId(this.serviceCenterId);
        product.setName(this.name);
        product.setDisplayName(this.displayName);
        product.setDescription(this.description);
        product.setActive(this.active);
        product.setActiveFrom(this.activeFrom);
        product.setActiveTo(this.activeTo);
        product.setBarcode(this.barcode);
        product.setSku(this.sku);
        return product;
    }

}
