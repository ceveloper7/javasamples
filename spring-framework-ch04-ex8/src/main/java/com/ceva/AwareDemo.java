package com.ceva;

import com.ceva.config.AwareConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareDemo {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(AwareConfig.class);
    }
}
