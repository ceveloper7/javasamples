package com.ceva.ex1.ch03.creating_objects;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BermudaTriangle {

    private static final int DIMESION = 50;
    private static final String RAINBOW = "\uD83C\uDF08";
    private static final String FOG = "\uD83C\uDF2B";
    private static final String OCTOPUS = "\uD83D\uDC19";

    // 1. Create a Polygon object
    static Polygon bermuda = new Polygon();

    private static void shipInBermudaTriangle(Polygon bermuda){
        // 2. Create a triangle with coordinates from 0 to 50
//        bermuda.addPoint(10, 40);
//        bermuda.addPoint(20, 5);
//        bermuda.addPoint(40,20);

        // 3. Ship position is a point, validate if a chosen point is inside the bermuda triangle object
        System.out.println("Ship is inside of Bermuda triangle? " + bermuda.contains(25, 25));

        // 4. Draw sea and bermuda triangle
        for(int y = 0; y < DIMESION; y++){
            for(int x = 0; x < DIMESION; x++){
                // validamos si el barco esta en el borde
                if(x == 0 || y == 0 || x == DIMESION -1  || y == DIMESION -1){
                    System.out.print(RAINBOW);
                }else{
                    System.out.print(bermuda.contains(x,y) ? OCTOPUS:FOG);
                }
            }
            System.out.println();
        }
    }

    private static Polygon resetWithRandomTriangle(Polygon polygon){
        // limpiamos el poligono
        polygon.reset();

        // creamos un poligono aleatorio
        Random random = ThreadLocalRandom.current();
        polygon.addPoint(random.nextInt(DIMESION), random.nextInt(DIMESION));
        polygon.addPoint(random.nextInt(DIMESION), random.nextInt(DIMESION));
        polygon.addPoint(random.nextInt(DIMESION), random.nextInt(DIMESION));

        return polygon;
    }

    private static Polygon createRandomTriangle(){
        return  resetWithRandomTriangle(new Polygon());
    }

    public static void main(String[] args) {
        shipInBermudaTriangle(createRandomTriangle());
    }
}
