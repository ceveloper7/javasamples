package com.ceva.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Records are data carrier, and their fields can be null.
 * If you want to prevent null, use a compact constructor to validate the fields
 * or use Optional to make it explicit.
 */
public class Lec07NullableFields {

    private static final Logger log = LoggerFactory.getLogger(Lec07NullableFields.class);

    public record Person(String name, Optional<String> nickname){

        // business requeriment: person nickname could be null, use Optional is a possibility
        Person(String name){
            this(name, Optional.empty());
        }
    }


    public static void main(String[] args) {
        var per1 = new Person("Jorge", Optional.of("coco"));
        log.info("{}", per1);

        var per2 = new Person("Carlos");
        log.info("{}", per2);
    }
}
