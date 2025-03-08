package org.ceva.providers;

import org.springframework.beans.factory.annotation.Value;

/*
 * Dependency is a simple object
 */
//@Component("provider")
public class ConfigurableMessageProvider implements MessageProvider{
    private String message;

    public ConfigurableMessageProvider(@Value("Configurable message") String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
