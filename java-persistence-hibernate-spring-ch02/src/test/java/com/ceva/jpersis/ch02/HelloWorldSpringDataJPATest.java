package com.ceva.jpersis.ch02;

import com.ceva.jpersis.ch02.repositories.MessageRepository;
import com.ceva.jpersis.ch02.springconfig.SpringDataConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class HelloWorldSpringDataJPATest {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void storeLoadMessage(){
        Message message = new Message();
        message.setText("Hello world from Spring Data JPA!");

        messageRepository.save(message);

        List<Message> messages = (List<Message>) messageRepository.findAll();
        Assertions.assertAll(
                ()-> Assertions.assertEquals(3, messages.size()),
                ()-> Assertions.assertEquals("Hello world from Spring Data JPA!", messages.get(2).getText())
        );
    }

}
