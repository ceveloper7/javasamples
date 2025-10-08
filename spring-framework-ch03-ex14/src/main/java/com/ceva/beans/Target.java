package com.ceva.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*
 * Cuando a spring no se le dice que hacer, llama al constructor sin argumentos, lo que significa que ninguna de las propiedades sera inyectadas
 * si no se le dice que hacer y se solicita una instancia entonces lanza un error.
 * @Lazy -> informa a Spring instaciar al bean solo cuando este es primero solicitado.
 */
@Component
@Lazy
public class Target {
    private static final Logger logger = LoggerFactory.getLogger(Target.class);

    public Foo fooOne;
    public Foo fooTwo;
    public Bar bar;

    // si ningun constructor posee @Autowired, se llama al constructor sin parametros (si existiese)
    // si no hay un constructor sin argumento, se lanza la excepcion BeanInstantiationException
    public Target(){
        logger.info("--> Target() called");
    }

    //@Autowired
    public Target(@Qualifier("foo") Foo foo){
        this.fooOne = foo;
        logger.info("--> Target(Foo) called");
    }

    //@Autowired
    public Target(@Qualifier("foo")Foo foo, Bar bar){
        this.fooOne = foo;
        this.bar = bar;
        logger.info("--> Target(Foo, Bar) called");
    }
}
