package com.ceva.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type){
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

    public static List<Dish> crearListaDePlatos() {
        List<Dish> platos = new ArrayList<>();
        Random random = new Random();
        String[] nombresBase = {"Plato", "Comida", "Delicia", "Manjar", "Opción"};
        String[] ingredientesMeat = {"Carne", "Res", "Cerdo", "Pollo", "Cordero"};
        String[] ingredientesFish = {"Salmón", "Atún", "Merluza", "Trucha", "Bacalao"};
        String[] ingredientesOther = {"Vegetal", "Tofu", "Pasta", "Arroz", "Huevo"};

        for (int i = 0; i < 200; i++) {
            Type tipo = Type.values()[random.nextInt(Type.values().length)];
            String nombre = nombresBase[random.nextInt(nombresBase.length)];
            boolean esVegetariano = false;
            int calorias = random.nextInt(800) + 100; // Calorías entre 100 y 900

            switch (tipo) {
                case MEAT:
                    nombre += " de " + ingredientesMeat[random.nextInt(ingredientesMeat.length)];
                    break;
                case FISH:
                    nombre += " de " + ingredientesFish[random.nextInt(ingredientesFish.length)];
                    break;
                case OTHER:
                    nombre += " " + ingredientesOther[random.nextInt(ingredientesOther.length)];
                    esVegetariano = random.nextBoolean(); // Algunos "OTHER" pueden ser vegetarianos
                    break;
            }

            platos.add(new Dish("id=" + (i + 1) + " " + nombre, esVegetariano, calorias, tipo));
        }
        return platos;
    }
}
