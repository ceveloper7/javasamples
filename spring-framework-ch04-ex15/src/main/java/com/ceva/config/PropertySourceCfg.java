package com.ceva.config;

import com.ceva.providers.ConfigurableMessageProvider;
import com.ceva.providers.MessageProvider;
import com.ceva.renders.MessageRenderer;
import com.ceva.renders.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:message.properties")
public class PropertySourceCfg {
    @Autowired
    Environment env;

    @Bean
    @Lazy
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRenderer(){
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }
}
