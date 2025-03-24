package com.ood.ch01.ricksGuitarChoise;

public class Guitar {
    private String serialNUmber, model;
    private double price;
    private Builder builder;
    private Type type;
    private Wood backWood, topWood;

    public Guitar(String serialNUmber, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood){
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

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }
}
