package com.ceva;

import com.ceva.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // para llamar al metodo destroy en un bean es necesario cerrar el ApplicationContext
        ctx.close();
        // usado en aplicaciones stand-alone
        //ctx.registerShutdownHook();

    }
}