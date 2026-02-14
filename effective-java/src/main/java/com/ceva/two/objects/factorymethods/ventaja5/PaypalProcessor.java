package com.ceva.two.objects.factorymethods.ventaja5;

public class PaypalProcessor implements PaymentProcessor{
    @Override
    public void process(double amount) {
        System.out.println("Processing paypal payment: " + amount);
    }
}
