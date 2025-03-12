package com.ceva.config;

import com.ceva.nameGenerator.SimpleBean;
import com.ceva.nameGenerator.SimpleBeanNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ceva.nameGenerator"}, nameGenerator = SimpleBeanNameGenerator.class)
public class ProjectConfig {
    /*
     * los beans que usan la anotacion @Bean son nombrados con el nombre de metodo
     */
    @Bean
    public SimpleBean anotherSimpleBean(){
        return new SimpleBean();
    }
}
