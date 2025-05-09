package com.ceva.ex1.ch02.loops;

/**
 * Loops: Create SVG Pearl chain
 */
public class Program2 {
    public static void main(String[] args) {
        System.out.println("<svg height=\"100\" width=\"1000\">");
        for(int i = 10; i < 510; i += 10){
            System.out.printf("""
                    <circle cx="%d" cy="20" r="5" fill="blue" />
                    """, i);
        }
        System.out.println("</svg>");
    }
}
