package com.hiczp.web.mystery.entity;

import javax.persistence.*;

/**
 * Created by czp on 17-7-10.
 */
@Entity
public class CouponInstance {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(optional = false)
    private Coupon coupon;

    @ManyToOne(optional = false)
    private Account account;

    @Column(nullable = false)
    private Float balance;

    public CouponInstance() {

    }

    public CouponInstance(Coupon coupon, Account account, Float balance) {
        this.coupon = coupon;
        this.account = account;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
