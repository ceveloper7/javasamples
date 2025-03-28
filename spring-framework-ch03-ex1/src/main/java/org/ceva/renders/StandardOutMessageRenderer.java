package org.ceva.renders;

import org.ceva.providers.MessageProvider;

public class StandardOutMessageRenderer implements MessageRenderer{

    private MessageProvider messageProvider;

    public StandardOutMessageRenderer(){
        System.out.println("--> StandardOutMessageRenderer: constructor called");
    }

    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("You must set the property messageProvider of class:"+StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        System.out.println("--> StandardOutMessageRenderer: setting the provider");
        this.messageProvider = messageProvider;
    }

    public MessageProvider getMessageProvider(){
        return messageProvider;
    }
}
