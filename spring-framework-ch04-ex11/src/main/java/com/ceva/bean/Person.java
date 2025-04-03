package com.ceva.bean;

import com.ceva.model.FullName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private FullName name;

    @Value("John Mayer")
    public void setName(FullName name){
        this.name = name;
    }

    public FullName getName(){
        return name;
    }
}
