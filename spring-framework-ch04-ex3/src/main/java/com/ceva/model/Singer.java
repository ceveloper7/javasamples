package com.ceva.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;

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

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("name", name)
                .append("age", age)
                .toString();
    }

    @PostConstruct
    public void postConstruct() throws Exception {
        logger.info("Initializing bean using 'afterPropertiesSet()'");
        if(name == null){
            logger.info("Using default name");
            this.name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("You must set the age property of any beans of type " + Singer.class);
        }
    }
}
