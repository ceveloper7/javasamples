package com.ceva.config;

import com.ceva.beans.FileManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    // cuando el bean fileManager se va a destruir, se llama antes a destroyMethod
    @Bean(destroyMethod = "destroyMethod")
    public FileManager fileManager(){
        return new FileManager();
    }
}
