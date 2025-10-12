package com.ceva.ddd.ch03.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entidad Tourist refactorizada
 * Aplicamos logica de dominio a traves del constructor y metodos
 * Evitamos estados mutables (no setters)
 * Encapsulamos sus datos y evitamos los valores nulos
 *
 */
public class Tourist {
    private String passportNumber;
    private String name;
    private Set<String> countries = new HashSet<>();

    public Tourist(String passportNumber, String name){
        // evitamos valores nulos
        Objects.requireNonNull(passportNumber, "Pasport number can not be null");
        Objects.requireNonNull(name, "Name can not be null");
        this.passportNumber = passportNumber;
        this.name = name;
    }

    public String getPassportNumber(){
        return passportNumber;
    }

    public String getName(){
        return name;
    }

    public Set<String> getCountries(){
        return Collections.unmodifiableSet(countries);
    }

    public void addCountry(String country){
        Objects.requireNonNull(country, "Country can not be null");
        countries.add(country);
    }
}
