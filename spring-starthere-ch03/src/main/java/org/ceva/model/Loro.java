package org.ceva.model;

import org.springframework.stereotype.Component;

@Component
public class Loro {
    private String name;

    public Loro(){
        this.name = "Carlota";
    }

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
