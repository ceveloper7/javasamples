package com.ceva.ch05.mapping;

import com.ceva.model.Dish;

import java.util.List;

/**
 * mapping
 */
public class Sample1 {
    public static void main(String[] args) {
        List<Dish> menu = Dish.crearListaDePlatos();

        // obtenemos todos los nombres de los platos
        List<String> dishNames =
                menu.stream()
                .map(dish -> dish.getName())
                .toList();

        dishNames.forEach(System.out::println);
    }
}
