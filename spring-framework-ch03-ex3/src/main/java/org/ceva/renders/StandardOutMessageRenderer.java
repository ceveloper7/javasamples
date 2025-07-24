package org.ceva.renders;

import org.ceva.providers.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("renderer")
public class StandardOutMessageRenderer implements MessageRenderer{

    private final MessageProvider messageProvider;

    /**
     * Constructor injection: nos aseguramos que el bean StandardOutMessageRenderer (renderer) sea creado con su dependencia.
     *                        Crear un StandardOutMessageRenderer bean sin un provider no tiene sentido por lo el
     *                        constructor injection es la mejor opcion. Ahora cuando se cree una instancia de StandardOutMessageRenderer
     *                        se injectar su dependencia
     * @param messageProvider
     */
    @Autowired
    public StandardOutMessageRenderer(MessageProvider messageProvider){
        System.out.println("--> StandardOutMessageRenderer: Injecting dependency using constructor");
        this.messageProvider = messageProvider;
    }

    @Override
    public void render() {
        if(messageProvider == null){
            throw new RuntimeException("You must set the property messageProvider of class:"+StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    public MessageProvider getMessageProvider(){
        return messageProvider;
    }
}
