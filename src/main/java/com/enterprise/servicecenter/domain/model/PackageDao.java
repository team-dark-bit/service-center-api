package com.enterprise.servicecenter.domain.model;

import com.enterprise.servicecenter.application.model.Package;
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

    protected PackageDao () {}

    public PackageDao(Package pck) {
        this.id = pck.getId();
        this.name = pck.getName();
        this.code = pck.getCode();
    }

    public Package toDomain() {
        Package pck = new Package();
        pck.setId(this.id);
        pck.setName(this.name);
        pck.setCode(this.code);
        return pck;
    }
}
