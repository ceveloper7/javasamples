package com.ceva.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Singer {
    private static final Logger logger = LoggerFactory.getLogger(Singer.class);

    private static final String DEFAULT_NAME = "No name";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name){
        logger.info("Calling setName for bean of type {}", Singer.class);
        this.name = name;
    }

    public void setAge(int age){
        logger.info("Calling setAge for bean of type {}", Singer.class);
        this.age = age;
    }

    /*
     * Metodo  usado como Callback Initialization
     * Verificamos si se ha establecido el valor a la propiedad name, si no, asignamos un name por defecto
     * Verificamos si se ha establecido el valor a la propiedad age, si no, lanzamos excepcion
     * el metodo de inicializacion no puede recibir ningun argumento
     */
    private void init(){
        logger.info("Inicializando bean");
        if(name == null){
            logger.info("Using default name");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("You must set the age property of any beans of type " + Singer.class);
        }
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("name", name)
                .append("age", age)
                .toString();
    }
}
