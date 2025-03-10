package com.ceva.valinject;

import com.ceva.config.ProjectConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component("injectSimpleSpEL")
public class InjectSimpleSpELDemo {
    @Value("#{injectSimpleConfig.name.toUpperCase()}")
    private String name;

    @Value("#{injectSimpleConfig.age+1}")
    private int age;

    @Value("#{injectSimpleConfig.height}")
    private double height;

    @Value("#{injectSimpleConfig.developer}")
    private boolean developer;

    @Value("#{injectSimpleConfig.ageInSeconds}")
    private Long ageInSeconds;

    @Override
    public String toString() {
        return "InjectSimpleSpELDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", developer=" + developer +
                ", ageInSeconds=" + ageInSeconds +
                '}';
    }
}
