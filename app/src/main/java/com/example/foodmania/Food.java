package com.example.foodmania;

public class Food {
    private String name;
    private int imageId;
    private String price;

    public Food(String name, int imageId,String price) {
        this.name = name;
        this.imageId = imageId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getPrice1() {
        return price;
    }


}