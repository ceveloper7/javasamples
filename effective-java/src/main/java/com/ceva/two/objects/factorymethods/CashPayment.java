package com.ceva.two.objects.factorymethods;

public class CashPayment implements PaymentMethod{
    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using cash");
    }
}
