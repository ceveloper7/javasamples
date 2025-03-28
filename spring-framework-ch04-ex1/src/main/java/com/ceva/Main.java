package com.ceva;

import com.ceva.config.ProjectConfig;
import com.ceva.model.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Ejecutando un metodo (init()) cuando un Bean es creado
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);
    }

    private static Singer getBean(String beanName, ApplicationContext ctx){
        try{
            Singer bean = (Singer) ctx.getBean(beanName);
            logger.info("found: {}", bean);
            return bean;
        }
        catch (BeanCreationException ex){
            logger.error("An error ocurred in bean configuration: " + ex.getMessage());
            return null;
        }
    }
}