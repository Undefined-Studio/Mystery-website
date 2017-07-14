package com.hiczp.web.mystery.entity;

import javax.persistence.*;

/**
 * Created by czp on 17-7-3.
 */
@Entity
public class Production {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false, length = 32)
    @Enumerated(EnumType.STRING)
    private ProductionType productionType;

    @OneToOne(fetch = FetchType.LAZY)
    private Level level;

    @Column(nullable = false)
    private Float price;

    @Column
    private Integer sort = 0;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductionType getProductionType() {
        return productionType;
    }

    public void setProductionType(ProductionType productionType) {
        this.productionType = productionType;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public enum ProductionType {
        BOOK
    }
}
