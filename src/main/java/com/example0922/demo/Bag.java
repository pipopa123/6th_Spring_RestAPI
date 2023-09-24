package com.example0922.demo;

public class Bag implements Item{
    private String brandName;
    private String color;

    public String wear(){
        return this.brandName+"のバッグを身につける";

    }

    public Bag(String brandName, String color) {
        this.brandName = brandName;
        this.color = color;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getColor() {
        return color;
    }
}



