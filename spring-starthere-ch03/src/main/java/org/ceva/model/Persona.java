package org.ceva.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Estableciendo relaciones entre instancias de Beans del Spring Context
 * Usamos @Autowired para inyectar valores a traves de los campos de clase
 */
@Component
public class Persona {
    private String name;

    // Establecemos la relacion entre Bean Loro y el Bean Persona
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
