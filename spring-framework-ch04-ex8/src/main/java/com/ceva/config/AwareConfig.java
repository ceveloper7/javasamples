package com.ceva.config;

import com.ceva.beans.NamedSinger;
import com.ceva.beans.ShutDownHookBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwareConfig {
    @Bean
    public NamedSinger johnMayer(){
        return new NamedSinger();
    }

    @Bean
    public ShutDownHookBean shutDownHook(){
        return new ShutDownHookBean();
    }
}
