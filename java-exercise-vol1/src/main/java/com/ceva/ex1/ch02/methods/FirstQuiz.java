package com.ceva.ex1.ch02.methods;

/**
 * What does Ding-dong do?
 */
public class FirstQuiz {
    private static long f(long value){
        return value == 0 ? 0 : (value % 10 + f(value / 10));
    }

    public static void main(String[] args) {
        long value = 192;
        System.out.println(f(value)); // print 12
    }
}
