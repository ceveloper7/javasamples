package com.ceva.jpersis.ch02;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Cuando trabajamos con JPA y necesitamos acceder a Hibernate API o vice versa,
 * Trabajamos con Hibernate y necesitamos crear un EntityManagerFactory desde una configuracion Hibernate
 *
 */
public class HelloWorldJPAToHibernateTest {
    // Obtenemos un SessionFactory de un EntityManagerFactory
    private static SessionFactory getSessionFactory(EntityManagerFactory entityManagerFactory){
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    // obtenemos un EntityFactoryManager de una configuracion Hibernate
    private static EntityManagerFactory createEntityManagerFactory(){
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Message.class);

        Map<String,String> properties = new HashMap<>();
        Enumeration<?> propertyNames = configuration.getProperties().propertyNames();

        while(propertyNames.hasMoreElements()){
            String element = (String)propertyNames.nextElement();
            properties.put(element, configuration.getProperties().getProperty(element));
        }

        return Persistence.createEntityManagerFactory("ch02", properties);
    }
}
