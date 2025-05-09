package com.ceva.ex1.ch02.loops;

/**
 * Loops: Go through a Mathematical Phenomenon
 */
public class Program4 {
    public static void main(String[] args) {
        double t = 0;
        int val;

        do{
            t = Math.random() * 10;
            if(t >= 0 && t < 10){
                if(t < 1)
                    t *= 2;
                else
                    t -= 1;
            }
            val = (int) t;
            System.out.println(t);
        }
        while (!(val <= 0));
    }
}
