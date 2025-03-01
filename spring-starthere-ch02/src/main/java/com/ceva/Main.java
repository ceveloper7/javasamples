package com.ceva;

import com.ceva.config.ProjectConfig;
import com.ceva.model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // var parrot = context.getBean("parrot2", Parrot.class);
        var parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());

        String msg = context.getBean(String.class);
        System.out.println(msg);

        Integer number = context.getBean(Integer.class);
        System.out.println(number);
    }
}