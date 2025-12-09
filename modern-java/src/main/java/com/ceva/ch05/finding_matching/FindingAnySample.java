package com.ceva.ch05.finding_matching;

import com.ceva.model.Dish;

import java.util.Optional;

/**
 * findAny -> retorna un elemento arbitrario del stream actual
 */
public class FindingAnySample {

    public static void main(String[] args) {
        // obtenemos un plato vegetariano. es posible que findAny no retorne  un elemento
        // Optional<T> representa la existencia o ausencia de un valor
        Optional<Dish> dish = Dish.crearListaDePlatos()
                .stream()
                .filter(Dish::isVegetarian)
                .findAny();

        // Optional<T> posee metodos disponibles como isPresent, ifPresent, get orElse
        if (dish.isPresent())
            System.out.println(dish);
    }
}
