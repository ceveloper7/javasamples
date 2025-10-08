package com.ceva;

import com.ceva.beans.Target;
import com.ceva.config.ProjectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Autowiring mechanism: Autowiring by Constructor
 */
public class ByConstructorAutowiring {
    private static final Logger logger = LoggerFactory.getLogger(ByConstructorAutowiring.class);

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // el bean target dispara el proceso de autowiring
        var target = context.getBean(Target.class);
        logger.info("target: Created target? {}" , target != null);
        logger.info("target: Injected bar? {}" , target.bar != null);
        logger.info("target: Injected fooOne? {}" , target.fooOne != null ? target.fooOne.id: "");
        logger.info("target: Injected fooTwo? {}" , target.fooTwo != null ? target.fooTwo.id : "");

    }
}