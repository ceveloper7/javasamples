package com.ceva.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class Util {

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> results = new ArrayList<>();
        for (T t : list){
            if(p.test(t))
                results.add(t);
        }
        return results;
    }

    public static  <T> void forEach(List<T> list, Consumer<T> c){
        for(T t : list){
            c.accept(t);
        }
    }
}
