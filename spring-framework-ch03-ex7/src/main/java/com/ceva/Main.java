package com.ceva;

import com.ceva.config.ChildConfig;
import com.ceva.config.ParentConfig;
import com.ceva.model.Song;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Inyeccion y ApplicationContext Anidados
 */
public class Main {
    public static void main(String[] args) {
        var parentContext = new AnnotationConfigApplicationContext();
        parentContext.register(ParentConfig.class);
        parentContext.refresh();

        var childContext = new AnnotationConfigApplicationContext();
        childContext.register(ChildConfig.class);
        childContext.setParent(parentContext);
        childContext.refresh();

        var song1 = (Song) childContext.getBean("song1");
        var song2 = (Song) childContext.getBean("song2");
        var song3 = (Song) childContext.getBean("song3");

        System.out.println("From Parent Context: " + song1.getTitle());
        System.out.println("From Child Context: " + song2.getTitle());
        System.out.println("From Child Context: " + song3.getTitle());
    }
}