package com.hiczp.web.mystery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by czp on 17-7-4.
 */
@Entity
public class Account {
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false, length = 32)
    private String username;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 32)
    private String nick;

    @Column
    private String avatar;

    @Column(length = 1024)
    private String gameFlag;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "account")
    private Set<CouponInstance> couponInstances;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGameFlag() {
        return gameFlag;
    }

    public void setGameFlag(String gameFlag) {
        this.gameFlag = gameFlag;
    }

    public Set<CouponInstance> getCouponInstances() {
        return couponInstances;
    }

    public void setCouponInstances(Set<CouponInstance> couponInstances) {
        this.couponInstances = couponInstances;
    }
}
