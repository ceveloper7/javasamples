package com.ceva.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Usamos @Autowired para inyectar valores a traves de los campos de clase
 */
@Component
public class Persona {
    private String name;

    @Autowired
    private Loro loro;

    public Persona(){
        this.name = "Ella";
    }

    public String getName() {
        return name;
    }

    public Loro getLoro() {
        return loro;
    }
}
