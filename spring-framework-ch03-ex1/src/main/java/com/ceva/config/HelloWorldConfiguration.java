package com.ceva.config;

import com.ceva.providers.HelloWorldMessageProvider;
import com.ceva.providers.MessageProvider;
import com.ceva.renders.MessageRenderer;
import com.ceva.renders.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public MessageProvider provider(){
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRenderer renderer(){
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    }
}
