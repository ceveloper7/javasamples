package com.ceva.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec08StaticMembers {
    private static final Logger log = LoggerFactory.getLogger(Lec08StaticMembers.class);

    public record Price(double amount, String currency){
        private static final String USD = "$";

        // static member
        static Price usd(double amount){
            return new Price(amount, USD);
        }
    }

    public static void main(String[] args) {
        var p = Price.usd(10.50);
        log.info("{}", p);
    }
}
