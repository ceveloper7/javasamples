package com.ceva.services;

import com.ceva.helpers.KeyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * Singleton bean, que cada vez que se llame a getMyKeyOpener se obtiene la misma instancia de KeyHelper
 */
@Component("standardLockOpener")
public class StandardLockOpener implements LockOpener{

    private KeyHelper keyHelper;

    /*
     * Obtenemos una instancia singleton de KeyHelper por medio del setter injection y esta instancia es almacenada
     * y retornada en cada llamada a getMyKeyOpener
     */
    @Autowired
    @Qualifier("keyHelper")
    public void setKeyHelper(KeyHelper keyHelper){
        this.keyHelper = keyHelper;
    }

    @Override
    public KeyHelper getMyKeyOpener() {
        return keyHelper;
    }

    @Override
    public void openLock() {
        //
        keyHelper.open();
    }
}
