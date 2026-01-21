package com.ceva.two.objects.factorymethods;

public class PaymentFactory {

    private PaymentFactory(){}

    public static PaymentMethod of(String type){
        return switch (type.toUpperCase()){
            case "CREDIT CARD" -> new CreditCardPayment();
            case "PAYPAL" -> new PayPalPayment();
            case "CASH" -> new CashPayment();
            default -> throw new IllegalArgumentException("Unknown payment type");
        };
    }
}
