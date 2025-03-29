package com.ceva.ex1.ch01;

import java.util.Random;

public class SvgCircle {
    private int x = 100;
    private int y = 110;
    private double r = 20.5;

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    // get radio from 10 to 20
    public double getR(){
        return new Random().nextDouble(10,19) ;
    }

    private String drawSvgCircle(){
        return "<svg height='100' width='1000'>\n\t<circle cx=" + getX() + " cy=" + getY() + " r=" + getR() + "/>\n</svg>";
    }

    public static void main(String[] args) {
        SvgCircle svgCircle = new SvgCircle();
        System.out.println(svgCircle.drawSvgCircle());
    }
}
