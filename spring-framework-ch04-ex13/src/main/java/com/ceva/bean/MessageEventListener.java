package com.ceva.bean;

import com.ceva.model.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageEventListener.class);

    @Override
    public void onApplicationEvent(MessageEvent event){
        LOGGER.info("Received: {}", event.getMessage());
    }
}
