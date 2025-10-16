package com.ceva.ch03.ordering_strategies;

import com.ceva.model.Apple;

import java.util.Comparator;
import java.util.List;

public class AppleComparatorUsingMethodReferences {

    public void comparingWithMethodRef(List<Apple> inventory){
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
    }

    public void sortingAppleWeightInDecreasing(List<Apple> inventory){
        inventory.sort(Comparator
                .comparing(Apple::getWeight)
                .reversed());
        System.out.println(inventory);
    }

    // luego que dos manzanas son ordenadas por el peso, aplicamos un ordenamiento por color
    public void chainingComparators(List<Apple> inventory){
        inventory.sort(
                Comparator.comparing(Apple::getWeight)
                        .reversed()
                        .thenComparing(Apple::getColor)
        );
        System.out.println(inventory);
    }

    public static void main(String[] args) {
        List<Apple> inventory = Apple.appleInventory();

        AppleComparatorUsingMethodReferences lref = new AppleComparatorUsingMethodReferences();
        //lref.sortingAppleWeightInDecreasing(inventory);
        lref.chainingComparators(inventory);
    }
}
