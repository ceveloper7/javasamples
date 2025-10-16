package com.ceva.ch03.ordering_strategies;

import com.ceva.model.Apple;

import java.util.Comparator;
import java.util.List;

public class AppleComparatorUsingLambda {

    private void usingLambdaExpressionV1(List<Apple> inventory){

        inventory.sort((Apple a1, Apple a2) -> a1.getWeight()-a2.getWeight());
        System.out.println(inventory);
    }

    private void usingLambdaExpressionV2(List<Apple> inventory){
        inventory.sort(Comparator.comparing((apple) -> apple.getWeight()));
        System.out.println(inventory);
    }

    public static void main(String[] args) {
        List<Apple> inventory = Apple.appleInventory();

        AppleComparatorUsingLambda test = new AppleComparatorUsingLambda();
        //test.usingLambdaExpressionV1(inventory);
        test.usingLambdaExpressionV2(inventory);
    }
}
