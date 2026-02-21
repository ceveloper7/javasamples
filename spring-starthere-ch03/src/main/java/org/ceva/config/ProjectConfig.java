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
    // Spring llama al metodo parrot() y agrega una instancia de Parrot al Spring Context
    @Bean
    public Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    // Spring llama al metodo person() y agrega una intancia de Person al SPring context
    @Bean
    public Person person(){
        Person pe = new Person();
        pe.setName("Ella");

        /**
         *  Spring primero pregunta si el bean Parrot ya existe en el Spring Context
         *  Si existe,  retorna directamente el bean parrot del spring context
         *  Si no existe, llama al metodo parrot() y agrega el valor que el metodo retorna al Spring Context y
         *  retorna el valor de la llamada actual
         */
        pe.setParrot(parrot());
        return pe;
    }
}
