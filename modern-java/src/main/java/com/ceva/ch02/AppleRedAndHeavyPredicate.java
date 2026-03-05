package com.ceva.ch02;

import com.ceva.model.Apple;
import com.ceva.model.Color;

/**
 * Filter Strategy 3
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple){
        // definimos el comportamiento
        return Color.RED.equals(apple.getColor()) && apple.getWeight() > 85;
    }
}
