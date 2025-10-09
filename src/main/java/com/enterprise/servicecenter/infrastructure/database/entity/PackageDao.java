package com.enterprise.servicecenter.infrastructure.database.entity;

import com.enterprise.servicecenter.domain.model.Package;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Package")
@Table(name = "packages")
public class PackageDao {

    @Id
    private String id;

    private String name;
    private String code;
    private Boolean active;

    protected PackageDao () {}

    public PackageDao(Package pck) {
        this.id = pck.getId();
        this.name = pck.getName();
        this.code = pck.getCode();
        this.active = true;
    }

    public Package toDomain() {
        Package pck = new Package();
        pck.setId(this.id);
        pck.setName(this.name);
        pck.setCode(this.code);
        return pck;
    }
}
