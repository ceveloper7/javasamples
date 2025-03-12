package com.ceva.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * En spring el scope por defecto es singleton, prototype indica a spring crear una nueva instancia
 * cada vez que el bean es solicitado
 */
@Component
@Scope(scopeName = "prototype")
public class Singer {
    private String name = "unknown";

    public Singer(@Value("John Mayer") String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                '}';
    }
}
