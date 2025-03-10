package com.ceva;

import com.ceva.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * USING IJECTION PARAMETERS
 *  Injecting Simple Values Sample
 */
public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var injectSimpleValue = context.getBean("injectSimple");

        System.out.println(injectSimpleValue);
    }
}