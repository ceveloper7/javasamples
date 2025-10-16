package com.ceva.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

public class NamedSinger implements BeanNameAware {
    private static final Logger logger = LoggerFactory.getLogger(NamedSinger.class);
    private String name;

    /**
     * este metodo es llamado antes que el ApplicationContext retorne la primera instancia del bean con .getBean()
     *
     */
    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    public void sing(){
        logger.info("Singer " + name + " - sing()");
    }
}
