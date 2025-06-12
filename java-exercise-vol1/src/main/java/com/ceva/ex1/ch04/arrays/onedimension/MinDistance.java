package com.ceva.ex1.ch04.arrays.onedimension;

import java.awt.*;

/**
 * Arrays: find the Nearest ciema
 */
public class MinDistance {
    private static double minDistance(Point[] points, int size) throws IllegalArgumentException{
        if(points.length == 0 || size > points.length)
            throw new IllegalArgumentException("Array is either empty or size out of bounds");


        /**
         * minDistance es un valor candidato, lo inicializamos con la distancia del primer objeto Point del array points y medimos
         * su distancia con el punto cero
         */
        double minDistance = points[0].distance(0,0);

        for(int i = 1; i < size; i++){
            double distance = points[i].distance(0,0);
            if(distance < minDistance){
                minDistance = distance;
            }
        }
        return minDistance;
    }

    private static Point minDistanceV2(Point[] points, int size){
        Point nearest = points[0];
        double minDistance = nearest.distance(0,0);

        for(int i = 1; i < size; i++){
            double distance = points[i].distance(0,0);
            if(distance < minDistance){
                minDistance = distance;
                nearest = points[i];
            }
        }
        return nearest;
    }

    public static void main(String[] args) {
        Point[] points = {new Point(10,20), new Point(12,2), new Point(44,4)};
        try
        {
            Point min = minDistanceV2(points, points.length);
            System.out.println("Minor distance: " + min.x + ", " + min.y);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
