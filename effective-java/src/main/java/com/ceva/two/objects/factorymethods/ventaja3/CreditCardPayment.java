package com.ceva.two.objects.factorymethods.ventaja3;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using Credit card");
    }
}
