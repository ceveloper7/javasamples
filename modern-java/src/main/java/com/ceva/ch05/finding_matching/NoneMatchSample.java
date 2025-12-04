package com.ceva.ch05.finding_matching;

import com.ceva.model.Dish;

/**
 * NoneMatch -> se aegura que ningun elemento en el stream coincida con el predicadp dado
 */
public class NoneMatchSample {

    public static void main(String[] args) {
        boolean isHealthy = Dish.crearListaDePlatos()
                .stream()
                .noneMatch(dish -> dish.getCalories() >= 1000);

        System.out.println("El menu es saludable: " + isHealthy);
    }
}
