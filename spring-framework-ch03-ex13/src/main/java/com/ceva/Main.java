package com.ceva;

import com.ceva.bean.Singer;
import com.ceva.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Resolviendo dependencias. Debemos evitar este diseno en lo posible, lo recomendado es usar constructor o setter injection
 * sin embargo, en casos donde tenemos que integrar legacy code con spring esta puede ser una alternativa.
 */
public class Main {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var johnMayer = ctx.getBean(Singer.class);
        johnMayer.sing();
    }
}