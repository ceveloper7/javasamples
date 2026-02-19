package com.ceva.ch02;

import com.ceva.model.Apple;

/**
 * Filter Strategy 1
 */
public class AppleHeavyWeightPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple){
        return apple.getWeight() > 85;
    }
}
