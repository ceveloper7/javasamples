package com.ceva.ex1.ch01;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class SvgCircle {
    private int x = 0;
    private int y = 0;
    private double r = 0;

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    // get radio from 10 to 20
    public double getR(){
        return new Random().nextDouble(10,19) ;
    }

    private void drawSvgCircle(){
        System.out.printf(
                Locale.US,
                "<svg height='100' width='1000'>\n\t<circle cx='%d' cy='%d' r='%.2f' />\n</svg>\n%n", getX(),getY(), getR());
    }

    private void askUserInput(){
        Scanner input = new Scanner(System.in);

        System.out.print("Create a Circle: Enter x: ");
        int valueX = input.nextInt();
        setX(valueX);

        System.out.println();
        System.out.print("Create a Circle: Enter y: ");
        int valueY = input.nextInt();
        setY(valueY);
    }

    private void process(){
        try{
            askUserInput();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SvgCircle circle = new SvgCircle();
        circle.process();
        circle.drawSvgCircle();
    }
}
