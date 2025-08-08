package com.ceva.sec02.lec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record CreditCard(String number) implements Payment {
    private static final Logger log = LoggerFactory.getLogger(CreditCard.class);

    @Override
    public void process(double amount) {
        log.info("processing amount: {} with credit card number: {}", amount, this.number);
    }
}
