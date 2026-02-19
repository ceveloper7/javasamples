package com.ceva.ch02;

import com.ceva.model.Apple;
import com.ceva.model.Color;

/**
 * Filter Strategy 2
 */
public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple){
        return Color.GREEN.equals(apple.getColor());
    }
}
