package com.ceva.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Uso de @Autowired para inyectr valores a traves del constructor
 */
@Component
public class PersonAutowiredByConstructor {
    private String name;

    private final Loro loro;

    @Autowired
    public PersonAutowiredByConstructor(Loro loro){
        this.loro = loro;
        this.name = "Fred";
    }

    public String getName() {
        return name;
    }

    public Loro getLoro() {
        return loro;
    }
}
