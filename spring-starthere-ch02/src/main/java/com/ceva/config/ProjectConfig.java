package com.ceva.config;

import com.ceva.model.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.ceva.model")
public class ProjectConfig {
    // Agregamos un objeto Parrot al Context Spring
    @Bean
    @Primary
    public Parrot parrot1(){
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Parrot parrot2(){
        var p = new Parrot();
        p.setName("Kiki");
        return p;
    }

    @Bean
    public Parrot parrot3(){
        var p = new Parrot();
        p.setName("Riki");
        return p;
    }

    @Bean
    public String hello(){
        return "Hello";
    }

    @Bean
    public Integer ten(){
        return 10;
    }
}
