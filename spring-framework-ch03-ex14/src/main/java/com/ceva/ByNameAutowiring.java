package com.ceva;

import com.ceva.beans.FieldTarget;
import com.ceva.config.ProjectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ByNameAutowiring {
    private static final Logger LOGGER = LoggerFactory.getLogger(ByNameAutowiring.class);

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var fieldTarget = ctx.getBean(FieldTarget.class);
        LOGGER.info("fieldTarget: Created fieldTarget? {}" , fieldTarget != null);
        LOGGER.info("fieldTarget: Injected bar? {}" , fieldTarget.bar != null);
        LOGGER.info("fieldTarget: Injected fooOne? {}" , fieldTarget.fooOne != null ? fieldTarget.fooOne.id: "");
        LOGGER.info("fieldTarget: Injected fooTwo? {}" , fieldTarget.fooTwo != null ? fieldTarget.fooTwo.id : "");
    }
}
