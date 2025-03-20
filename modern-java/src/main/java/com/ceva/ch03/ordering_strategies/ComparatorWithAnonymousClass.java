package com.ceva.ch03.ordering_strategies;

import com.ceva.model.Apple;

import java.util.Comparator;
import java.util.List;

public class ComparatorWithAnonymousClass {
    public static void main(String[] args) {
        List<Apple> inventory = Apple.appleInventory();

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        System.out.println(inventory);
    }
}
