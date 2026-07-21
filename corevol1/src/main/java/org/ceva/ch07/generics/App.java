package org.ceva.ch07.generics;

public class App {
    public static void main(String[] args) {
        Utilities_01.printGenericValue("Alberto");
        Utilities_01.printGenericValue(100);
        Utilities_01.printKeyValue("Username", "barcvilla");

        System.out.println(MathUtils.sum(3,3));
    }
}
