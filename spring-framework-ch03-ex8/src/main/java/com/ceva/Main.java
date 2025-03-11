package com.ceva;

import com.ceva.collectionInject.CollectingBean;
import com.ceva.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Inyectando una coleccion de objetos
 */
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var collectingBean = context.getBean(CollectingBean.class);
        collectingBean.printCollections();
    }
}