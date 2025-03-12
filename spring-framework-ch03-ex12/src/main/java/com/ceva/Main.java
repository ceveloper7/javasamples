package com.ceva;

import com.ceva.beans.Singer;
import com.ceva.config.ProjectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Entendiendo el modo de instanciacion de Beans
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var singer1 = context.getBean(Singer.class);
        var singer2 = context.getBean(Singer.class);

        /*
         * aunque los valores de los objetos String son iguales, la identidad no lo es
         */
        logger.info("identity Equal?: " + (singer1==singer2)); // false
        logger.info("Value equal?: " + singer1.equals(singer2)); // false

        logger.info(singer1.toString());
        logger.info(singer2.toString());

    }
}