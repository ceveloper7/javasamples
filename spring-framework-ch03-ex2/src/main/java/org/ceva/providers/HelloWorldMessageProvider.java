package org.ceva.providers;

import org.springframework.stereotype.Component;

/**
 * @Component -> anotacion que marca una clase como un bean en Spring
 * @Service -> define un service bean, el cual es un bean que provee servicios que otros beans pueden requerir
 * @Autowired -> anotacion usada para injectar una dependencia ya sea en un setter o constructor. @Autowired le dice al contenedor IoC
 *               de Spring que busque un bean de ese tipo y lo use como un argumento cuando se llame a dicho metodo o constructor
 */
@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider{

    public HelloWorldMessageProvider(){
        System.out.println("--> HelloWorldMessageProvider: constructor called");
    }

    @Override
    public String getMessage() {
        return "Hello world";
    }
}
