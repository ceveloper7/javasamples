package com.ceva.config;

import com.ceva.model.Parrot;
import com.ceva.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Person person(){
        Person pe = new Person();
        pe.setName("Ella");
        pe.setParrot(parrot()); // establecemos una referencia al bean parrot
        return pe;
    }
}
