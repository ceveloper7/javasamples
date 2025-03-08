package org.ceva.config;

import org.ceva.model.Parrot;
import org.ceva.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 3.1.2 Conexion de los Beans utilizando los parametros del metodo anotado @Bean
 */
@Configuration
public class OtherProjectConfig {

    @Bean
    public Parrot parrot(){
        var parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }

    /*
     * Por medio de definir un parametro en el metodo le indicamos a spring que provea un bean de su context del tipo de parametro
     * Spring inyecta el bean parrot en el bean person para que se produzca una relacion "tiene-un" entre Person y Parrot
     */
    @Bean
    public Person person(Parrot parrot){
        var p = new Person();
        p.setName("ELla");
        p.setParrot(parrot);
        return p;
    }
}
