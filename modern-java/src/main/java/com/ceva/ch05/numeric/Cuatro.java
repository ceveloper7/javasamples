package com.ceva.ch05.numeric;

import com.ceva.model.Dish;

import java.util.OptionalInt;

/**
 * Default values
 */
public class Cuatro {
    public static void main(String[] args) {
        OptionalInt maxCalories = Dish.crearListaDePlatos()
                .stream()
                .mapToInt(Dish::getCalories)
                .max();

        int caloriasMax = maxCalories.orElse(1);
        System.out.println("Plato con mayor calorias: " + caloriasMax);
    }
}
