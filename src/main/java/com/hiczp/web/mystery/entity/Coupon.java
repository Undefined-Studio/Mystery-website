package com.hiczp.web.mystery.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by czp on 17-7-10.
 */
@Entity
public class Coupon {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false)
    private Float value;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "coupon")
    private Set<CouponInstance> couponInstances;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Set<CouponInstance> getCouponInstances() {
        return couponInstances;
    }

    public void setCouponInstances(Set<CouponInstance> couponInstances) {
        this.couponInstances = couponInstances;
    }
}
