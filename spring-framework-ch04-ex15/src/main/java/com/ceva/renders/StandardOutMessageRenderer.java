package com.ceva.renders;

import com.ceva.providers.MessageProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardOutMessageRenderer implements MessageRenderer {
    private static final Logger LOGGER = LoggerFactory.getLogger(StandardOutMessageRenderer.class);

    private MessageProvider messageProvider;

    @Override
    public void render() {
        LOGGER.info(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public MessageProvider getMessageProvider(){
        return messageProvider;
    }
}
