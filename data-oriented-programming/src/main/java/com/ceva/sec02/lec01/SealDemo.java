package com.ceva.sec02.lec01;

public class SealDemo {
    public static void main(String[] args) {
        processPayment(new Cash());
        processPayment(new CreditCard());
        processPayment(new CashRewards());
    }

    private static void processPayment(Payment payment){
        payment.process(100);
    }
}
