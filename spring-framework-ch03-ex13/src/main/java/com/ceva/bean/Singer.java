package com.ceva.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/*
 * el bean johnMayer depende del bean gopher y lo recupera por si mismo accediendo al ApplicationContext
 */
@DependsOn("gopher")
@Component("johnMayer")
public class Singer implements ApplicationContextAware {
    private ApplicationContext ctx;
    private Guitar guitar;

    public Singer(){}

    public void sing(){
        var guitar = ctx.getBean("gopher", Guitar.class);
        guitar.sing();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
