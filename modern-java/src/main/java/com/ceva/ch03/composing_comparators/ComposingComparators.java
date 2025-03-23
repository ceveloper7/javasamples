package com.ceva.ch03.composing_comparators;

import com.ceva.model.Apple;

import java.util.Comparator;
import java.util.List;

public class ComposingComparators {

    private void reversedOrder(){
        List<Apple> inventory = Apple.appleInventory();

        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println(inventory);
    }

    private void chainingComparators(){
        List<Apple> inventory = Apple.appleInventory();

        /*
         * Encadenando comparators
         * Si encontramos dos apple con el mismo weight, el segundo comparator by Color permite definir que apple ira primero.
         */
        inventory.sort(Comparator.comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));

        System.out.println(inventory);
    }

    public static void main(String[] args) {
        ComposingComparators c = new ComposingComparators();
        c.chainingComparators();
        //c.reversedOrder();
    }
}
