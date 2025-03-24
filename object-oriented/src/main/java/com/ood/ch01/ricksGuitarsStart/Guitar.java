package com.ood.ch01.ricksGuitarsStart;

public class Guitar {
    private String serialNUmber, builder, model, type, backWood, topWood;
    private double price;

    public Guitar(String serialNUmber, double price, String builder, String model, String type, String backWood, String topWood){
        this.serialNUmber = serialNUmber;
        this.price = price;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public String getSerialNUmber() {
        return serialNUmber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getBackWood() {
        return backWood;
    }

    public String getTopWood() {
        return topWood;
    }
}
