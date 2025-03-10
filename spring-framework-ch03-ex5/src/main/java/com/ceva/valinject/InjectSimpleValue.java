package com.ceva.valinject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("injectSimple")
public class InjectSimpleValue {
    @Value("John Mayer")
    private String name;

    @Value("40")
    private int age;

    @Value("1.92")
    private double height;

    @Value("false")
    private boolean isDeveloper;

    @Value("1223456578")
    private Long ageInSeconds;

    @Override
    public String toString() {
        return "InjectSimpleValue{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", isDeveloper=" + isDeveloper +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
