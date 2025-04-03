package com.ceva;

import com.ceva.bean.Publisher;
import com.ceva.config.ApplicationEventCfg;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationEventDemo {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(ApplicationEventCfg.class);

        Publisher pub = (Publisher) ctx.getBean("publisher");
        pub.publish("I send an SOS to the world... ");
        pub.publish("... I hope that someone gets my...");
        pub.publish("... Message in a bottle");
    }
}
