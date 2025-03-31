package com.ceva.config;

import com.ceva.beans.MessageDigestFactoryBean;
import com.ceva.beans.MessageDigester;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ceva.beans"})
public class MessageDigestConfig {
    @Bean
    public MessageDigestFactoryBean shaDigest(){
        MessageDigestFactoryBean shaDigest = new MessageDigestFactoryBean();
        shaDigest.setAlgorithmName("SHA1");
        return shaDigest;
    }

    @Bean
    public MessageDigestFactoryBean defaultDigest(){
        return new MessageDigestFactoryBean();
    }

    @Bean
    public MessageDigester digester()throws Exception{
        MessageDigester messageDigester = new MessageDigester();
        messageDigester.setDigest1(shaDigest().getObject());
        messageDigester.setDigest2(defaultDigest().getObject());
        return messageDigester;
    }
}
