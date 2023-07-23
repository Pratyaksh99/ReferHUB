package com.example.kaushik.referhub;

public class User {

    String email;
    String password;
    Coupon coupon;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        coupon = null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public User() {
    }
}