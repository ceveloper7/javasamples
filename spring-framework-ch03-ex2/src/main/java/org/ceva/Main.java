package org.ceva;

import org.ceva.config.ProjectConfig;
import org.ceva.renders.MessageRenderer;
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