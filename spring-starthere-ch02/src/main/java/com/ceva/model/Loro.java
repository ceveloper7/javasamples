package com.ceva.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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

    @PostConstruct
    public void init(){
        this.name = "Rigoberta";
    }
}
