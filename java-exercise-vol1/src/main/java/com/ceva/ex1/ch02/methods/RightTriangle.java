package com.ceva.ex1.ch02.methods;

public class RightTriangle {
    private static boolean isRightTriangle(double a, double b, double c){
        return a * a == b*b + c*c
                || b * b == a*a + c*c
                || c * c == b*b + a*a;
    }

    public static void main(String[] args) {
        System.out.println(RightTriangle.isRightTriangle(5,3,2));
    }
}
