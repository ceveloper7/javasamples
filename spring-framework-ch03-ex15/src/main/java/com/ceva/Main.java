package com.ceva;

import com.ceva.config.ProjectConfig;
import com.ceva.model.TrickyTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var target = ctx.getBean(TrickyTarget.class);

        logger.info("target: Created target? {}" , target != null);
        logger.info("target: Injected bar? {}" , target.bar != null);
        logger.info("target: Injected fooOne? {}" , target.fooOne != null ? target.fooOne.toString(): "");
        logger.info("target: Injected fooTwo? {}" , target.fooTwo != null ? target.fooTwo.toString() : "");
    }
}