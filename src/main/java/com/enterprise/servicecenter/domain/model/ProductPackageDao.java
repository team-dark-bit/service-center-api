package com.enterprise.servicecenter.domain.model;

import com.enterprise.servicecenter.application.model.ProductPackage;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ProductPackage")
@Table(name = "products_packages")
public class ProductPackageDao {

    @Id
    private String id;

    private String productId;
    private String packageId;
    private String unitId;
    private Double quantity;
    private String codedName;
    private String imageUrl;
    private Boolean status;

    protected ProductPackageDao () {}

    public ProductPackageDao(ProductPackage productPackage) {
        this.id = productPackage.getId();
        this.productId = productPackage.getProductId();
        this.packageId = productPackage.getPackageId();
        this.unitId = productPackage.getUnitId();
        this.quantity = productPackage.getQuantity();
        this.codedName = productPackage.getCodedName();
        this.imageUrl = productPackage.getImageUrl();
        this.status = productPackage.getStatus();
    }

    public ProductPackage toDomain() {
        ProductPackage productPackage = new ProductPackage();
        productPackage.setId(this.id);
        productPackage.setProductId(this.productId);
        productPackage.setPackageId(this.packageId);
        productPackage.setUnitId(this.unitId);
        productPackage.setQuantity(this.quantity);
        productPackage.setCodedName(this.codedName);
        productPackage.setImageUrl(this.imageUrl);
        productPackage.setStatus(this.status);
        return productPackage;
    }

}
