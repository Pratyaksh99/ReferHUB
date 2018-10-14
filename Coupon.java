package com.example.kaushik.referhub;

public class Coupon {

    String url;
    String category;
    String desc;

    public Coupon(String desc, String category, String url){
        this.url = url;
        this.category = category;
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public String getCategory() {
        return category;
    }

    public String getDesc() {
        return desc;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}