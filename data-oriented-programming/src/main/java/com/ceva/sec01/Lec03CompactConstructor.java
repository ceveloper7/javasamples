package com.ceva.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec03CompactConstructor {
    private static final Logger log = LoggerFactory.getLogger(Lec03CompactConstructor.class);

    // canonical constructor
    record Person(String firstName, String lastName){

        // business requeriments: we need to uppercase the lastName
        Person{
            lastName =  lastName.toUpperCase();
        }
    }

    public static void main(String[] args) {
        var person = new Person("John", "Doe");

        log.info("{}", person);

    }
}
