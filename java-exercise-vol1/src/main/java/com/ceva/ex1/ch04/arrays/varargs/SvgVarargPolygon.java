package com.ceva.ex1.ch04.arrays.varargs;

public class SvgVarargPolygon {
    private static void printSvgPolygon(int... points) throws IllegalArgumentException{
        if(points.length % 2 == 1)
            throw new IllegalArgumentException("Array has an odd number of arguments: " + points.length);

        System.out.print("<polygon points=\"");
        for(int i = 0; i < points.length; i+=2){
            System.out.printf("%d,%d ", points[i], points[i+1]);
        }
        System.out.println("\" />");
    }

    public static void main(String[] args) {
        printSvgPolygon(200, 10, 250, 190, 160, 210);
    }
}
