package com.ceva.ex1.ch02.loops;

/**
 * Create rotate SVG Rectangles
 */
public class Program1 {
    public static void main(String[] args) {
        System.out.println("<svg height=\"200\" width=\"200\">");
        int angle = 10;
        for (int rotation = 0; rotation < 360; rotation += angle){
            System.out.printf("""
                    <rect x="50" y="50" width="100" height="100" \
                    stoke="black" fill="none" \
                    transform="rotate(%d 100 100)" />%n""", rotation);
        }
        System.out.println("</svg>");
    }
}
