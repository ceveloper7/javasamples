package com.ceva.ch05.filtering_with_predicate;

import com.ceva.model.Dish;

import java.util.List;

/**
 * dropWhile
 */
public class Sample3 {
    public static void main(String[] args) {
        List<Dish> menu = Dish.crearListaDePlatos();

        List<Dish> filteredDish = menu.stream()
                /**
                 * mientras el predicado retorne true, los dishes se eliminaran, tan pronto el predicado retorna false
                 * se detiene el procesamiento del stream y se retornan todos los elementos restantes en el stream
                 */
                .dropWhile(dish -> dish.getCalories() < 320)
                .toList();

        filteredDish.forEach(System.out::println);
    }
}
