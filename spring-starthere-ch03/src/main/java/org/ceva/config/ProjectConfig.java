package org.ceva.config;

import org.ceva.model.Parrot;
import org.ceva.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 3.1.1 Conexion entre Beans mediante una llamada directa de metodo entre los metodos @Bean
 */
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
