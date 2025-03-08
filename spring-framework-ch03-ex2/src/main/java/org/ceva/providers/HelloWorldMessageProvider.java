package org.ceva.providers;

import org.springframework.stereotype.Component;

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
