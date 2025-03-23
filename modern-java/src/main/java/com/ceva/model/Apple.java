package com.ceva.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Apple{
    private int weight = 0;
    private Color color;

    public Apple(int weight){
        this.weight = weight;
        this.color = Color.UNKNOWN;
    }

    public Apple(int weight, Color color){
        this.weight = weight;
        this.color = color;
    }

    public Apple() {
        this.weight = 0;
        this.color = Color.UNKNOWN;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @SuppressWarnings("boxing")
    @Override
    public String toString() {
        return String.format("Apple{color=%s, weight=%d}", color, weight);
    }

    public static List<Apple> appleInventory(){
        return Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(77, Color.RED),
                new Apple(91, Color.RED),
                new Apple(77, Color.GREEN),
                new Apple(88, Color.RED),
                new Apple(110, Color.GREEN),
                new Apple(81, Color.BLUE),
                new Apple(75, Color.BLUE)
        );
    }
}
