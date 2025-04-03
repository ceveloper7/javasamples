package com.ceva;

import com.ceva.bean.Person;
import com.ceva.config.CustomPropertyEditorCfg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Custom Property Editor
 */
public class CustomPropertyEditorDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomPropertyEditorDemo.class);

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(CustomPropertyEditorCfg.class);
        var person = ctx.getBean("person", Person.class);
        LOGGER.info("Person full name: " + person.getName());
    }
}
