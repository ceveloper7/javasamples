package com.ceva.services;

import com.ceva.helpers.KeyHelper;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/*
 * Singleton bean que recibe la injeccion de un no singleton bean gracias de la injeccion de Lookup method
 */
@Component("abstractLockOpener")
abstract class AbstractLockOpener implements LockOpener {
    /*
     * definimos el Lookup method. este metodo retorna una instancia de bean que no es singleton
     */
    @Lookup("keyHelper")
    @Override
    public abstract KeyHelper getMyKeyOpener();

    @Override
    public void openLock(){
        getMyKeyOpener().open();
    }
}
