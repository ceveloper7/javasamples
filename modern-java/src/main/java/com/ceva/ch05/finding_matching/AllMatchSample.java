package com.ceva.ch05.finding_matching;

import com.ceva.model.Dish;

/**
 * allMatch -> verifica si todos los elementos del stream coinciden con el predicado dado.
 */
public class AllMatchSample {

    public static void main(String[] args) {
        // queremos saber si el menu es saludable (si estan por debajo de 1000 calorias, lo es)
        boolean menuIsHealthy = Dish.crearListaDePlatos()
                .stream()
                .allMatch(dish -> dish.getCalories() < 1000);

        System.out.println("The menu is healthy: " + menuIsHealthy);
    }
}
