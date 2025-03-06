package com.ceva.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/*
 * ConstructorConfusion bean - Spring utiliza el constructor con anotacion @Autowired para crear una instancia
 */
@Component
public class ConstructorConfusion {
    private String someValue;

    public ConstructorConfusion(String someValue){
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }

    /*
     * La anotacion le dice a Spring que utilice este constructor para inicializar este bean, sin esta
     * anotacion Spring no puede decidir por si mismo que constructor debe usar y daria un error
     */
    @Autowired
    public ConstructorConfusion(@Value("90") int someValue){
        System.out.println("ConstructorConfusion(int) called");
        this.someValue = "Number: " + Integer.toString(someValue);
    }

    @Override
    public String toString(){
        return someValue;
    }

    public static void main(String[] args) {
        // instanciamos un spring context vacio
        var context = new AnnotationConfigApplicationContext();
        // colocamos en el context vacio el bean ConstructorConfusion
        context.register(ConstructorConfusion.class);
        // refrescamos y recreamos todos los bean en el contexto
        context.refresh();

        var cc = context.getBean(ConstructorConfusion.class);
        System.out.println("Does this work? " + cc);
    }
}
