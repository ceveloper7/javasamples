package com.ceva.config;

import com.ceva.model.Bar;
import com.ceva.model.TrickyTarget;
import com.ceva.services.Foo;
import com.ceva.services.FooImplOne;
import com.ceva.services.FooImplTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"com.ceva.model", "com.ceva.services"})
public class ProjectConfig {
    @Bean
    //@Primary
    public Foo fooImplOne(){
        return new FooImplOne();
    }

    @Bean
    public Foo fooImplTwo(){
        return new FooImplTwo();
    }

    @Bean
    public Bar bar(){
        return new Bar();
    }

    @Bean
    public TrickyTarget trickyTarget(){
        return new TrickyTarget();
    }
}
