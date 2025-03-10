package com.ceva;

import com.ceva.config.ProjectConfig;
import com.ceva.valinject.InjectSimpleSpELDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Using SpEL (Spring Expression Language) para inyectar propiedades de otro bean
 */
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var simpelDemo = context.getBean(InjectSimpleSpELDemo.class);
        System.out.println(simpelDemo);
    }
}