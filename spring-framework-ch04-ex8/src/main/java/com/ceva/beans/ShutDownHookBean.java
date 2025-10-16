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
            /**
             * Ya no ncesitamos registrar un ShutDownHook en el ApplicationContext
             * ShutDownHook lo registramos en el bean ShutDownHookBean y este se
             * encarga de llamar a registerShutDownHook() y cierra automaticamente el ApplicatonContext,
             * se remueven lo hooks.
             */
            ((GenericApplicationContext)ctx).registerShutdownHook();
        }
    }
}
