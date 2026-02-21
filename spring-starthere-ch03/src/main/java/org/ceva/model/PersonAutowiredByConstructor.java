package org.ceva.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Uso de @Autowired para inyectr valores a traves del constructor
 */
@Component
public class PersonAutowiredByConstructor {
    private String name;

    private final Loro loro;

    /**
     * Cuando Spring crea el bean de tipo PersonAutowiredByConstructor, llama al constructor anotado con @Autowired
     * y le inyecta el bean Loro que existe en el spring context y lo pasa al constrcutor como un valor de parametro
     */
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
