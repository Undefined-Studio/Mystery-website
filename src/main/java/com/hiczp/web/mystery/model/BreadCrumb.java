package com.hiczp.web.mystery.model;

/**
 * Created by czp on 17-7-5.
 */
public class BreadCrumb {
    private String name;
    private String link;

    public BreadCrumb(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
