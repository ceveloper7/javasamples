package com.ceva.ch05.reducing;

import com.ceva.model.Dish;

import java.util.List;

public class CountingSample {
    public static void main(String[] args) {
        long dishCount = Dish.crearListaDePlatos()
                .stream()
                .count();

        System.out.println("Dish count menus: " + dishCount);
    }
}
