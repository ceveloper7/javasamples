package com.ceva;

import com.ceva.beans.NamedSinger;
import com.ceva.config.AwareConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Making bean name aware
 * Using ApplicationContextAware
 */
public class Main {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AwareConfig.class);
        //ctx.registerShutdownHook(); ya no se necesita por el bean shutDownHook

        var singer = ctx.getBean(NamedSinger.class);
        singer.sing();
    }
}