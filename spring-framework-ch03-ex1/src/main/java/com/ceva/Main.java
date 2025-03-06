package com.ceva;

import com.ceva.config.HelloWorldConfiguration;
import com.ceva.renders.MessageRenderer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Basic Configuration Overview
 */
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        var renderer = context.getBean(MessageRenderer.class);

        renderer.render();
    }
}