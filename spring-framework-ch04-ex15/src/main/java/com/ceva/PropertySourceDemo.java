package com.ceva;

import com.ceva.config.PropertySourceCfg;
import com.ceva.renders.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Property source
 */
public class PropertySourceDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PropertySourceCfg.class);
        MessageRenderer mr = ctx.getBean("messageRenderer", MessageRenderer.class);
        mr.render();
    }
}
