package com.ceva;

import com.ceva.beans.AnotherTarget;
import com.ceva.config.ProjectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Cuando no hay constructores declarador pero existen setters anotados con @Autowired, spring los usara e identificara los beans
 * para ser inyectados basados en su tipo.
 */
public class ByTypeAutowiring {
    private static final Logger LOGGER = LoggerFactory.getLogger(ByTypeAutowiring.class);

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var anotherTarget = ctx.getBean(AnotherTarget.class);
        LOGGER.info("anotherTarget: Created anotherTarget? {}" , anotherTarget != null);
        LOGGER.info("anotherTarget: Injected bar? {}" , anotherTarget.bar != null);
        LOGGER.info("anotherTarget: Injected fooOne? {}" , anotherTarget.fooOne != null ? anotherTarget.fooOne.id: "");
        LOGGER.info("anotherTarget: Injected fooTwo? {}" , anotherTarget.fooTwo != null ? anotherTarget.fooTwo.id : "");
    }
}
