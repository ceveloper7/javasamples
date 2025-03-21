package com.ceva;

import com.ceva.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Ejecutando un metodo cuando un Bean es destruido
 */
public class Main {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // cuando se cierra el ApplicationContext antes se invoca al metodo destroyMethod del bean FileManager
        ctx.close();
    }
}
