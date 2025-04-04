package com.ceva.highschool;

import com.ceva.service.FoodProviderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("highschool")
@ComponentScan(basePackages = {"com.ceva.service", "com.ceva.highschool"})
public class HighSchoolCgf {
    @Bean
    FoodProviderService foodProviderService(){
        return new FoodProviderServiceImpl();
    }
}
