package com.ceva.ch02;

import com.ceva.model.Apple;
import com.ceva.model.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * 2.1.1 Filtrando manzanas
 */
public class Sample1 {
    // Primer intento filtrar las manzanas verdes
    public static List<Apple> filterGreenApples(List<Apple> invenory){
        List<Apple> greenAppleList = new ArrayList<>();
        for (Apple apple : invenory){
            // si se cumple, la manzana se agrega a la lista de manzanas verdes
            if (apple.getColor() == Color.GREEN)
                greenAppleList.add(apple);
        }
        return greenAppleList;
    }

    // Segundo intento: Parametizando el color
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color appleColor){
        List<Apple> applesList = new ArrayList<>();
        for (Apple apple : inventory)
            if (apple.getColor().equals(appleColor))
                applesList.add(apple);

        return applesList;
    }

    // el cliente solicita distinguir entre manzanas por su peso
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
        List<Apple> appleList = new ArrayList<>();
        for(Apple apple : inventory)
            if (apple.getWeight() > weight)
                appleList.add(apple);

        return appleList;
    }

    /**
     * En los metodos de arriba podemos notar que estamos duplicando la implementacion con una ligera
     * diferencia entre metodos. en este tercer intento podemos filtrar por cada atributo de la clase Apple
     * como por Color y Weight
     */
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag){
        List<Apple> appleList = new ArrayList<>();
        for (Apple apple : inventory){
            // cuando flag es true filtra por color, de lo contrario filtra por peso
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight))
                appleList.add(apple);
        }
        return appleList;
    }

    public static void main(String[] args) {
        List<Apple> inventory = Apple.appleInventory();
        List<Apple> result = Sample1.filterApples(inventory, Color.GREEN, 85, true);
        result = Sample1.filterApples(inventory, Color.BLUE, 80, false);
        System.out.println(result);
    }
}
