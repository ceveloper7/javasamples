package com.ceva.config;

import com.ceva.beans.FileManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean()
    public FileManager fileManager(){
        return new FileManager();
    }
}
