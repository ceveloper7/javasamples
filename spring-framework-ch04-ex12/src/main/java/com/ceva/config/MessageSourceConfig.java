package com.ceva.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageSourceConfig {
    @Bean
    public MessageSource messageSource(){
        var messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("labels");
        return messageSource;
    }
}
