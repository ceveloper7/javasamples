package com.ceva.ch05.finding_matching;

import com.ceva.model.Dish;

/**
 * AnyMatch -> este metodo nos permite responder la pregunta, hay algun elemento en el stream que coincida con el predicado dado.
 */
public class AnyMatchSample {

    public static void main(String[] args) {
        if (Dish.crearListaDePlatos().stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly");
        }
    }
}
