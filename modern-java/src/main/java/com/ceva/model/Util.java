package com.ceva.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public final class Util {

    // Utilizamos un Predicate cuando necesitamos representar un expresion boolean que usa un objeto de tipo T
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> results = new ArrayList<>();
        for (T t : list){
            if(p.test(t))
                results.add(t);
        }
        return results;
    }

    // Usamos un Consumer cuando necesitamos acceder a un objeto T y realizamos algunas operaciones sobre el
    public static  <T> void forEach(List<T> list, Consumer<T> c){
        for(T t : list){
            c.accept(t);
        }
    }

    // Tomamos un objeto generico tipo T como input y retornamos un objeto generico tipo R
    public static <T,R> List<R> map(List<T> list, Function<T, R> f){
        List<R> results = new ArrayList<>();
        for (T t : list){
            results.add(f.apply(t));
        }
        return results;
    }

    public static String addHeader(String text){
        return "From Raoul, Mario and Alan: " + text;
    }

    public static String addFooter(String text){
        return text + " Kind regards";
    }

    public static String checkSpelling(String text){
        return text.replaceAll("labda", "lambda");
    }
}
