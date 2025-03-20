package com.ceva.ch03.ordering_strategies;

import com.ceva.model.Apple;

import java.util.Comparator;
import java.util.List;

public class ComparingWithMethodReferences {
    public static void main(String[] args) {
        List<Apple> inventory = Apple.appleInventory();

        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
    }
}
