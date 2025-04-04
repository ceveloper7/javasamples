package com.ceva;

import com.ceva.highschool.HighSchoolCgf;
import com.ceva.kindergarten.KindergartenCfg;
import com.ceva.service.FoodProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfileDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileDemo.class);

    public static void main(String[] args) {
        //var profile = System.getProperty("spring.profiles.active");

        var ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setDefaultProfiles("kindergarten");
        //ctx.getEnvironment().setActiveProfiles(profile);
        ctx.register(KindergartenCfg.class, HighSchoolCgf.class);
        ctx.refresh();

        var foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
        var lunchSet = foodProviderService.provideLunchSet();
        lunchSet.forEach(food -> LOGGER.info("Food {}", food.getName()));
    }
}
