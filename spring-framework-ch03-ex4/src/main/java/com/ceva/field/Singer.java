package com.ceva.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("singer")
public class Singer {
    /*
     * Spring encuentra en el spring context un bean Inspiration y lo inyecta automaticamente
     * en el campo inspiration del bean Singer
     */
    @Autowired
    private Inspiration inspiration;

    public void sing(){
        System.out.println("... " + inspiration.getLyric());
    }
}
