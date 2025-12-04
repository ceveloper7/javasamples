package com.ceva.ch05.finding_matching;

import com.ceva.model.Dish;

import java.util.Optional;

/**
 * findAny -> retorna un elemento arbitrario del stream actual
 */
public class FindingElement {

    public static void main(String[] args) {
        // obtenemos un plato vegetariano. es posible que findAny no retorne  un elemento por ello usamos Optional<T>
        Optional<Dish> dish = Dish.crearListaDePlatos()
                .stream()
                .filter(Dish::isVegetarian)
                .findAny();

        if (dish.isPresent())
            System.out.println(dish);
    }
}
