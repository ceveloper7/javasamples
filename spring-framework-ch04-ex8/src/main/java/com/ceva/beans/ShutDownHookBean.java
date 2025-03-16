package com.ceva.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

public class ShutDownHookBean implements ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // validamos para ver si soporta registerShutdownHook
        if(ctx instanceof GenericApplicationContext){
            // registramos un ShutdownHook en el ApplicationContext
            ((GenericApplicationContext)ctx).registerShutdownHook();
        }
    }
}
