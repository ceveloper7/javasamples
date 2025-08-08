package com.ceva.sec02.lec02;

public sealed interface Payment permits CreditCard, Cash, Paypal {
    public void process(double amount);
}
