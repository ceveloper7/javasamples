package com.ceva.ch03.composing_comparators;

import com.ceva.model.Apple;
import com.ceva.model.Color;
import com.ceva.model.Util;

import java.util.List;
import java.util.function.Predicate;


public class ComposingPredicates {

    // Predicate and, negate, or
    private void getRedAndHeavyApple(){
        List<Apple> inventory = Apple.appleInventory();

        Predicate<Apple> redApple = (apple)-> apple.getColor() == Color.RED;

        Predicate<Apple> redAndHeavyApples = redApple
                .and(apple -> apple.getWeight() > 80);

        System.out.println(Util.filter(inventory, redAndHeavyApples));;
    }

    private void getRedAndHeavyAppleOrBlue(){
        List<Apple> inventory = Apple.appleInventory();

        Predicate<Apple> redApple = (apple)-> apple.getColor() == Color.RED;
        Predicate<Apple> redAndHeavyOrBlueApples = redApple
                .and((apple) -> apple.getWeight() > 280)
                .or((apple) -> apple.getColor() == Color.BLUE);

        System.out.println(Util.filter(inventory, redAndHeavyOrBlueApples));
    }

    public static void main(String[] args) {
        ComposingPredicates p = new ComposingPredicates();
        //p.getRedAndHeavyApple();
        p.getRedAndHeavyAppleOrBlue();
    }
}
