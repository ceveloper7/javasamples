package com.ceva.ex1.ch02.loops;

/**
 * Loop: Displaying trees with Ornaments
 */
public class Program11 {
    private static final int width = 5;

    public static void main(String[] args) {
        for ( int stars = 1, spaces = (width - 1) / 2; stars <= width; stars += 2, spaces-- ) {

            for ( int i = 0; i < spaces; i++ )
                System.out.print( ' ' );

            for ( int col = 0; col < stars; col++ )
                System.out.print( Math.random() < 0.9 ? '*' : 'o' );

            System.out.println();
        }
    }
}
