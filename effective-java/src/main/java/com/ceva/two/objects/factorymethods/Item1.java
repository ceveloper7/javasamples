package com.ceva.two.objects.factorymethods;

import java.math.BigInteger;
import java.util.Random;

/**
 * Creating and Destroy Objects
 * Item 1: Considerar static factory methods en lugar de constructores
 */
public class Item1 {

    public static void main(String[] args) {
        /**
         * Ventaja 1
         * A diferencia de los constuctores, static factory methods tienen nombres
         */
        BigInteger p = BigInteger.probablePrime(4, new Random());
        System.out.println(p.toString());

        /**
         * Ventaja 2
         * Los static factory methods no estan obligados a crear un nuevo objeto en cada invocacion.
         * Nos permite reutilizar instancias de objeto ya creados
         */
        Color red1 = Color.valueOf("Red");
        Color red2 = Color.valueOf("Red");

        System.out.println("is red1 and red2 equals? " + red1.equals(red2));

        /**
         * Ventaja 3
         * Los static factory method pueden retornar un objeto de cualquier subtipo
         */
        PaymentMethod credit = PaymentFactory.of("CREDIT CARD");
        PaymentMethod paypal = PaymentFactory.of("PAYPAL");
        PaymentMethod cash = PaymentFactory.of("CASH");

        credit.pay(8000);
        paypal.pay(11000);
        cash.pay(5000);

        /**
         * Ventaja 4. Segun el parametro el static factory methos retorna una implementacion concreta
         * y el usuario no lo sabe
         */
        Cache cache = Cache.create(75);
        cache.put("user1", "Carlos");
        cache.put("user2", "Ana");

        System.out.println(cache.get("user2"));
    }
}
