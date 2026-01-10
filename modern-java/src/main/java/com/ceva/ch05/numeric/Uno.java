package com.ceva.ch05.numeric;

import com.ceva.model.Dish;

public class Uno {
    public static void main(String[] args) {
        int calorias = Dish.crearListaDePlatos()
                .stream()
                // generamos Stream<Integer>
                .map(Dish::getCalories)
                // reduce permite hacer calculos
                // el problema con el codigo es que cada objeto Integer debe unboxed a dato primitivo int
                .reduce(0, Integer::sum);

        System.out.println("Total Calorias del menu: " + calorias);
    }
}
