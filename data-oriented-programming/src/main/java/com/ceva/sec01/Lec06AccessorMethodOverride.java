package com.ceva.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Record accessor methods can be overridden without changing their method signature
 */
public class Lec06AccessorMethodOverride {
    private static final Logger log = LoggerFactory.getLogger(Lec06AccessorMethodOverride.class);

    record Person(String firstName, String lastName){

        // jvm create accessors methods for firstName and lastName but we can add new accessor methods
        public Optional<String> firstNameOptional(){
            return Optional.ofNullable(this.firstName);
        }
    }


    public static void main(String[] args) {
        var person1 = new Person("John", "Doe");


    }
}
