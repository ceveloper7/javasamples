package com.ceva.config;

import com.ceva.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * Declarando Singleton scope Bean usando @Bean
 */
@Configuration
public class ProjectConfiguration {
    @Bean
    public CommentService commentService(){
        return new CommentService();
    }
}
