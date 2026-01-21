package com.ceva.two.objects.factorymethods;

public class CreditCardPayment implements PaymentMethod{
    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using Credit card");
    }
}
