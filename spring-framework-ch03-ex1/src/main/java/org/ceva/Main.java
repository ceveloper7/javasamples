package org.ceva;

import org.ceva.config.HelloWorldConfiguration;
import org.ceva.renders.MessageRenderer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Basic Configuration Overview
 */
public class Main {
    public static void main(String[] args) {
        // 1. Create Spring Context with beans configured in HelloWorldConfiguration class
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        // 2. Get a reference to renderer bean
        var renderer = context.getBean("renderer", MessageRenderer.class);

        renderer.render();
    }
}