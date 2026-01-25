package com.ceva.two.objects.factorymethods;

public abstract class Cache {

    /**
     * Static factory method que retorna distintas implementaciones
     * segun el parametro cambia la clase concreta.
     */
    public static Cache create(int maxEntries){
        if (maxEntries <= 100){
            return new SmallCache(maxEntries);
        }else{
            return new LargeCache(maxEntries);
        }
    }

    public abstract void put(String key, String value);
    public abstract String get(String key);
}
