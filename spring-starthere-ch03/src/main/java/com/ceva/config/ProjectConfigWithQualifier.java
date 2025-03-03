package com.ceva.config;

import com.ceva.model.Parrot;
import com.ceva.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfigWithQualifier {
    @Bean
    public Parrot parro1(){
        var p = new Parrot();
        p.setName("Kokko");
        return p;
    }

    @Bean
    public Parrot parrot2(){
        var p = new Parrot();
        p.setName("Mikki");
        return p;
    }

    @Bean
    public Person person(@Qualifier("parrot2") Parrot parrot){
        var p = new Person();
        p.setName("Ella");
        p.setParrot(parrot);
        return p;
    }
}
