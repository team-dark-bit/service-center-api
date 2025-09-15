package com.enterprise.servicecenter.domain.model;

import com.enterprise.servicecenter.application.model.Unit;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Unit")
@Table(name = "units")
public class UnitDao {

    @Id
    private String id;

    private String name;
    private String code;

    protected UnitDao () {}

    public UnitDao(Unit unit) {
        this.id = unit.getId();
        this.name = unit.getName();
        this.code = unit.getCode();
    }

    public Unit toDomain() {
        Unit unit = new Unit();
        unit.setId(this.id);
        unit.setName(this.name);
        unit.setCode(this.code);
        return unit;
    }

}
