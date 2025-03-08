package org.ceva;

import org.ceva.config.ProjectConfig;
import org.ceva.field.Singer;
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