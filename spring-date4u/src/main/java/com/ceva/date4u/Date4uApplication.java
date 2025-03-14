package com.ceva.date4u;

import com.ceva.date4u.core.FileSystem;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.unit.DataSize;

import java.util.Arrays;

@SpringBootApplication
public class Date4uApplication {
    public static void main(String[] args) {
        // Inicializando Spring container
//        SpringApplication app = new SpringApplication(Date4uApplication.class);
//        app.setHeadless(false);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);

//        var ctx = SpringApplication.run(Date4uApplication.class, args);
//        Arrays.stream(ctx.getBeanDefinitionNames())
//                .sorted()
//                .forEach(System.out::println);

        SpringApplication.run(Date4uApplication.class, args);
//        var ctx = new AnnotationConfigApplicationContext(Date4uApplication.class);
//        var fs = ctx.getBean(FileSystem.class);

    }
}