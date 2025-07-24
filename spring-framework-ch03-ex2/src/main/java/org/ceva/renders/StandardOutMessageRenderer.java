package org.ceva.renders;

import org.ceva.providers.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Bean component StandardOutMessageRenderer "renderer" tiene una dependencia al bean HelloWorldMessageProvider "provider"
 */
@Component("renderer")
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

    /**
     * @Autowired -> anotacion usada para injectar una dependencia ya sea en un setter o constructor. @Autowired le dice al contenedor IoC
     *               de Spring que busque un bean de ese tipo y lo use como un argumento cuando se llame a dicho metodo o constructor.
     */
    @Override
    @Autowired // setter injection
    public void setMessageProvider(MessageProvider provider) {
        System.out.println("--> Injecting dependency using setter method.");
        this.messageProvider = provider;
    }

    public MessageProvider getMessageProvider(){
        return messageProvider;
    }
}
