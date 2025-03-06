package com.ceva;

import com.ceva.config.ProjectConfig;
import com.ceva.renders.MessageRenderer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Ejemplo donde declaramos Beans utilizando Anotaciones Estereotipo
 */
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var renderer = context.getBean(MessageRenderer.class);

        renderer.render();
    }
}