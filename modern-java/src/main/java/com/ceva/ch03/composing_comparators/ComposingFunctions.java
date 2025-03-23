package com.ceva.ch03.composing_comparators;

/*
 * Function posee dos metodos para componer expresiones lambda:
 * andThen
 * compose
 *
 */

import com.ceva.model.Util;

import java.util.function.Function;

public class ComposingFunctions {

    private void multiplyNumbersWithAndThen(){
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        // en matematica: g(f(x))
        Function<Integer, Integer> h = f.andThen(g);

        System.out.println("result: " + h.apply(5));
    }

    private void multipleNUmbersWithCompose(){
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        // en matematicas f(g(x))
        Function<Integer, Integer> h = f.compose(g);
        System.out.println("result: " + h.apply(1));
    }

    private void textTransformation(){
        Function<String, String> addHeader = Util::addHeader;
        Function<String, String> transformation = addHeader
                .andThen(Util::checkSpelling)
                .andThen(Util::addFooter);

        System.out.println();
    }

    public static void main(String[] args) {
        ComposingFunctions c = new ComposingFunctions();
        c.multiplyNumbersWithAndThen();
        c.multipleNUmbersWithCompose();
        c.textTransformation();
    }
}
