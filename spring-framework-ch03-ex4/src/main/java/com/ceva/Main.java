package com.ceva;

import com.ceva.config.ProjectConfig;
import com.ceva.field.Singer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Using field injection
 */
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Singer singer = context.getBean(Singer.class);
        singer.sing();
    }
}