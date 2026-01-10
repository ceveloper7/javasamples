package com.ceva.ch05.numeric;

import com.ceva.model.Dish;

/**
 * Primitive Stream specialization: IntStream, DoubleStream, LongStream
 */
public class Dos {
    public static void main(String[] args) {
        // Mapping to a Numeric Stream
        int calories = Dish.crearListaDePlatos()
                // return Stream<Dish>
                .stream()
                // return IntStream
                .mapToInt(Dish::getCalories)
                .sum();

        System.out.println("Total de calorias en el menu: " + calories);
    }
}
