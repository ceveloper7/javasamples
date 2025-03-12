package com.ceva;

import com.ceva.config.ProjectConfig;
import com.ceva.nameGenerator.SimpleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/*
 * Bean name generator demo
 */
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach((beanName)-> logger.debug(beanName));
//        try{
//            var sb = context.getBean(SimpleBean.class);
//        }
//        catch(NoSuchBeanDefinitionException e){
//            logger.debug("Bean '{}' could not be found", e.getBeanName());
//        }
    }
}