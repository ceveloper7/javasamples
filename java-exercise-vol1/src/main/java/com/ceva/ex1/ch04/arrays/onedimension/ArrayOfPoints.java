package com.ceva.ex1.ch04.arrays.onedimension;

import java.awt.*;
import java.util.Arrays;

/**
 * Arrays: one dimension arrays - Arrays of Points
 */
public class ArrayOfPoints {
    public static void main(String[] args) {
        // array de 4 elementos, todos null
        Point[] points = {null, null, null, null};
        // creamos un nuevo objeto Point
        Point p = new Point();
        // establecemos la coordenadas para el objeto point p
        p.setLocation(1,2);
        // el primer elemento del array contiene una referencia al objeto point p
        points[0] = p;
        // modificamos las coordenadas para el objeto point p
        p.setLocation(3,4);
        // el elemento en la segunda posicion del array points apunta al objeto point p
        points[1] = p;
        // La referencia a la segunda posicion del array points es pasada al objeto q
        Point q = points[1];
        // establecemos nuevas coordenadas para el objeto point que referencia q
        q.setLocation(5,6);
        
        points[2] = points[3] = q;

        System.out.println(Arrays.toString(points));
    }
}
