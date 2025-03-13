package com.ceva.config;

import com.ceva.beans.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ceva.beans"})
public class ProjectConfig {
    @Bean
    public Foo anotherFoo(){
        return new Foo();
    }
}
