package com.ceva.two.objects.factorymethods;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Clase Color
 * Impide la herencia
 * Refuerza la inmutabilidad
 */
public final class Color {
    // almacenamos instancias unicas de la clase Color por clave.
    private static final Map<String, Color> CACHE = new ConcurrentHashMap<>();
    private final String name;

    // impedimos el new Color() y obligamos a usar el factory method valueOf()
    private Color(String name){
        this.name = name;
    }

    // static factory method
    public static Color valueOf(String name){
        return CACHE.computeIfAbsent(name, Color::new);
    }

    public String getName(){
        return name;
    }
}
