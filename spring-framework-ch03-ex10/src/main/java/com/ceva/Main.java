package com.ceva;

import com.ceva.config.ProjectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach((beanName)-> logger.debug(beanName));
    }
}