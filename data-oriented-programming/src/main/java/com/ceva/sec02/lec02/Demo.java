package com.ceva.sec02.lec02;

public class Demo {
    public static void main(String[] args) {
        processPayment(new CreditCard("123456789"));
        processPayment(new Paypal("ceva@gamil.com"));
    }

    private static void processPayment(Payment payment){
        payment.process(100);
    }
}
