package com.ceva.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Records can not extends classes but records can implements interfaces
 */
public class Lec09RecordInterface {

    private static final Logger log = LoggerFactory.getLogger(Lec09RecordInterface.class);

    public record EmailTemplate(String template) implements UnaryOperator<String>{

        @Override
        public String apply(String name) {
            return template.formatted(name);
        }
    }

    public static void main(String[] args) {
        var emailTemplate = new EmailTemplate("Hi %s, Welcome...");
        Stream.of("sam", "mike", "jake")
                .map(emailTemplate)
                .forEach(log::info);
    }
}
