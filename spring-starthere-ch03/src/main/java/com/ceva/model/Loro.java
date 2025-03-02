package com.ceva.model;

import org.springframework.stereotype.Component;

@Component
public class Loro {
    private String name;

    public Loro(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Loro: " + name;
    }
}
