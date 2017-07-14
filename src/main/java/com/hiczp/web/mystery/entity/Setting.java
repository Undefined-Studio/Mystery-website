package com.hiczp.web.mystery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by czp on 17-7-13.
 */
@Entity
public class Setting {
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false)
    private String property;

    @Column(nullable = false)
    private String value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
