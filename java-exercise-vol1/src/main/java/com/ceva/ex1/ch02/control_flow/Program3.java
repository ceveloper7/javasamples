package com.ceva.ex1.ch02.control_flow;

import java.util.Locale;
import java.util.Random;

/**
 * Create SVG Color with Random Colors
 */
public class Program3 {
    public static void main(String[] args) {
        String[] color = {"red", "green", "blue"};
        Random random = new Random();
        for (int i = 0; i < color.length; i++){
            int ranVal = random.nextInt(color.length);
            System.out.printf( "<circle cx='20', cy='20', r='5', fill='%s' />\n", color[ranVal]);
        }
    }
}
