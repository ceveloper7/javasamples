package com.ceva.kindergarten;

import com.ceva.kindergarten.FoodProviderServiceImpl;
import com.ceva.service.FoodProviderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("kindergarten")
@ComponentScan(basePackages = {"com.ceva.service", "com.ceva.kindergarten"})
public class KindergartenCfg {
    @Bean
    FoodProviderService foodProviderService(){
        return new FoodProviderServiceImpl();
    }
}
