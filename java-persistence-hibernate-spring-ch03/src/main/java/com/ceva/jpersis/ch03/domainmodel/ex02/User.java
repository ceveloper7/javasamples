package com.ceva.jpersis.ch03.domainmodel.ex02;

import java.util.StringTokenizer;

public class User {
    private String name;
    private String lastname;

    public String getName(){
        return name + " " + lastname;
    }

    public void setName(String name){
        StringTokenizer token = new StringTokenizer(name);
        name = token.nextToken();
        lastname = token.nextToken();
    }
}
