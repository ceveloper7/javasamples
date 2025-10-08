package com.ceva.config;

import com.ceva.model.Singer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    /*
     * metodo init() callback initialization
     */
    @Bean(initMethod = "init")
    public Singer singerOne(){
        Singer singer = new Singer();
        singer.setName("John Mayer");
        singer.setAge(43);
        return singer;
    }

    @Bean(initMethod = "init")
    public Singer singerTwo(){
        // la propiedad name no esta configurada
        Singer singer = new Singer();
        singer.setAge(42);
        return singer;
    }

    @Bean(initMethod = "init")
    public Singer singerThree(){
        Singer singer = new Singer();
        singer.setName("John Butler");
        singer.setAge(40);
        return singer;
    }
}
