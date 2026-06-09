package org.ceva.adam;

import java.util.Map;

public record Developer(String language, int age) {
    // Constructor especializado que acepta objeto Map.Entry
    // facilita la conversion de datos crudos en objetos con nombre
    public Developer(Map.Entry<String,Integer> entry){
        this(entry.getKey(), entry.getValue());
    }
}
