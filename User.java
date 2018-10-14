package com.example.prats.referhub;

public class User {

    String email;
    String password;
    String coupon;

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

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public User() {
    }
}
