package com.ceva.ch05.filtering_with_predicate;

import com.ceva.model.Dish;

import java.util.List;

/**
 * Truncating stream with limit operation
 */
public class Sample5 {
    public static void main(String[] args) {

        List<Dish> menu = Dish.crearListaDePlatos();

        // seleccionar los 3 primeros platos que tienen mas de 300 calorias
        List<Dish> dishesWithCaloriesGreaterThan300 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .toList();

        dishesWithCaloriesGreaterThan300.forEach(System.out::println);
    }
}
