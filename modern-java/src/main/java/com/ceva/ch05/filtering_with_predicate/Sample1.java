package com.ceva.ch05.filtering_with_predicate;

import com.ceva.model.Dish;

import java.util.List;

/**
 * Filtrando los platos vegetarianos
 */
public class Sample1 {
    public static void main(String[] args) {
        List<Dish> menu = Dish.crearListaDePlatos();

        // filtrando platos vegetarianos
        List<Dish> vegetarianDishes = menu.stream()
                .filter(Dish::isVegetarian)
                .toList();

        vegetarianDishes.forEach(System.out::println);
    }
}
