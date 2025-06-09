package com.ceva.ex1.ch02.methods;

/**
 * Program2 : LinePrinter
 */
public class Program2 {

    private static void line(int len){
        line(len, '-');
    }

    private static void line(int len, char c){
        while (len-- > 0){
            System.out.print(c);
        }
    }

    private static void line(String prefix, int len, char c, String suffix){
        System.out.print(prefix);
        line(len, c);
        System.out.print(suffix);
    }

    public static void main(String[] args) {
        Program2.line("$", 4, '=', "$");
    }
}
