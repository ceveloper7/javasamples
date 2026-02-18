package com.ceva.two.objects.builder;

/**
 * Construir un objeto con muchos parametros usando Java Beans pattern
 */
public class NutritionFactsV2 {

    private int servingSize; // required
    private int servings; // required
    private int calories; // optional
    private int fat; // optional
    private int sodium; // optional
    private int carbohydrate; // optional

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public static void main(String[] args) {
        /**
         * El patron Java Beans no tiene la desventaja de NutritionFacts
         */
        NutritionFactsV2 cocaCola = new NutritionFactsV2();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);

    }
}
