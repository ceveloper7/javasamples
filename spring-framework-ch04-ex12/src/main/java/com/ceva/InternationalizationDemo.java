package com.ceva;

import com.ceva.config.MessageSourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

/**
 * Spring Internationalization
 */
public class InternationalizationDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(InternationalizationDemo.class);

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(MessageSourceConfig.class);

        Locale english = Locale.ENGLISH;
        Locale ukrainian = new Locale("uk","UA");
        LOGGER.info(ctx.getMessage("msg", null, english));
        LOGGER.info(ctx.getMessage("msg", null, ukrainian));
        LOGGER.info(ctx.getMessage("nameMsg", new Object[]{ "Iuliana", "Cosmina" }, english));
        LOGGER.info(ctx.getMessage("nameMsg", new Object[]{ "Iuliana", "Cosmina" }, ukrainian));
        ctx.close();
    }
}
