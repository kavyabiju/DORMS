package com.example.dormsadmin;

public class model {
    private String img_url;
    public model(){}
    public model(String img_url){
        this.img_url = img_url;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
