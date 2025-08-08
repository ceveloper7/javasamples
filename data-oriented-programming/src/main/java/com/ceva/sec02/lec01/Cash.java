package com.ceva.sec02.lec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public sealed class Cash extends Payment permits CashRewards{
    private static final Logger log = LoggerFactory.getLogger(Cash.class);

    @Override
    public void process(double amount) {
        log.info("processing cash transaction {}", amount);
    }
}
