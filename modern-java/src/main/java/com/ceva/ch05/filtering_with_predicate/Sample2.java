package com.ceva.ch05.filtering_with_predicate;

import com.ceva.model.Dish;

import java.util.List;

/**
 * Slicing a stream using a predicate
 */
public class Sample2 {
    /**
     * Seleccionamos los platos menores a 320 calorias, la seleccion se detiene cuando encuentra un plato
     * que no cumple el predicado
     */
    public static void main(String[] args) {
        List<Dish> menu = Dish.crearListaDePlatos();

        List<Dish> filteredMenu = menu.stream()
                .takeWhile(dish -> dish.getCalories() < 400)
                .toList();

        filteredMenu.forEach(System.out::println);

    }
}
