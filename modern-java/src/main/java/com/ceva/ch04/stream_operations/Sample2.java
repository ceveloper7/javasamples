package com.ceva.ch04.stream_operations;

import com.ceva.model.Dish;

import java.util.List;

/**
 * Obtenemos los 3 primeros platos que superen las 800 calorias
 */
public class Sample2 {
    public static void main(String[] args) {
        List<Dish> menu = Dish.crearListaDePlatos();

        List<String> threeHighCaloricsDishNames =
                menu.parallelStream()
                        // filtramos los platos con mas de 800 calorias
                        .filter((dish) -> dish.getCalories() > 800)
                        // a los platos filtrados, obtenemos su nombre
                        .map(Dish::getName)
                        // del mapa de platos, limitamos a los primeros 3 elementos
                        .limit(3)
                        // guardamos en una coleccion de String
                        .toList();

        for(String dishName : threeHighCaloricsDishNames){
            System.out.println(dishName);
        }
    }
}
