package com.ceva.jpersis.ch02;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HelloWorldJPATest {
    @Test
    public void storeLoadMessage(){
        try(
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch02");
                EntityManager em = emf.createEntityManager()){

            em.getTransaction().begin();
            Message message = new Message();
            message.setText("Hello world!");
            em.persist(message);
            em.getTransaction().commit();

            em.getTransaction().begin();
            // generamos query: SELECT * FROM message;
            List<Message> messages = em.createQuery("select m from Message m", Message.class).getResultList();
            messages.get(messages.size()-1).setText("Hello world from JPA!");

            em.getTransaction().commit();

            Assertions.assertAll(
                    ()-> Assertions.assertEquals(1, messages.size()),
                    ()-> Assertions.assertEquals("Hello world from JPA!", messages.get(0).getText())
            );
        }

    }
}
