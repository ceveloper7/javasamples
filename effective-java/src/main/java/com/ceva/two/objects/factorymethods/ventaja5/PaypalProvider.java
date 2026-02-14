package com.ceva.two.objects.factorymethods.ventaja5;

public class PaypalProvider implements PaymentProcessorProvider{
    @Override
    public PaymentProcessor create() {
        return new PaypalProcessor();
    }
}
