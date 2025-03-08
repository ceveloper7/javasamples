package org.ceva.config;

import org.ceva.providers.HelloWorldMessageProvider;
import org.ceva.providers.MessageProvider;
import org.ceva.renders.MessageRenderer;
import org.ceva.renders.StandardOutMessageRenderer;
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
