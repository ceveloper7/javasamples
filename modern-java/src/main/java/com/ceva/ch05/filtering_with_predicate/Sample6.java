package com.ceva.ch05.filtering_with_predicate;

import com.ceva.model.Dish;

import java.util.List;

/**
 * Skipping stream elements
 */
public class Sample6 {
    public static void main(String[] args) {
        List<Dish> menu = Dish.crearListaDePlatos();

        /**
         * Saltamos los dos primeros platos del stream que contiene platos que superan las 800 calorias
         */
        List<Dish> skip =
                // Stream<Dish>
                menu.stream()
                // Stream<Dish>
                .filter(dish -> dish.getCalories() > 800)
                // Stream<Dish> - descartamos 2 primeros platos
                .skip(2)
                // List<Dish>
                .toList();

        skip.forEach(System.out::println);
    }
}
