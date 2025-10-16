package com.ceva.ch03.ordering_strategies;

import com.ceva.model.Apple;

import java.util.Comparator;
import java.util.List;

/*
 * La interface Comparator representa un metodo abstracto compare que tiene la firma: (T, T) -> int
 */
public class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight() - o2.getWeight();
    }

    public static void main(String[] args) {
        List<Apple> inventory = Apple.appleInventory();

        inventory.sort(new AppleComparator());

        for(Apple apple : inventory){
            System.out.println(apple);
        }
    }
}
