package com.ceva.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Lec04CompactConstructorValidation {
    private static final Logger log = LoggerFactory.getLogger(Lec04CompactConstructorValidation.class);

    // canonical constructor
    record Person(String firstName, String lastName, int age){

        // business requeriments: we need to uppercase the lastName
        Person{
            Objects.requireNonNull(firstName, "First name can not be null");
            Objects.requireNonNull(lastName, "Last name can not be null");
            lastName =  lastName.toUpperCase();

            if (age < 10)
                throw new IllegalArgumentException("age must be major than 10");
        }
    }

    public static void main(String[] args) {
        var person = new Person("John", "Doe", 47);

        log.info("{}", person);

    }
}
