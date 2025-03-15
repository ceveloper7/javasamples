package com.ceva.config;

import com.ceva.model.Dependency;
import com.ceva.model.MultiInit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Dependency dependency(){
        return new Dependency();
    }

    @Bean(initMethod = "initMe")
    public MultiInit multiInitBean(){
        return new MultiInit();
    }
}
