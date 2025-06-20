package com.ceva.ex1.ch05.string;

/**
 * Character and STring processing - Build diamond
 */
public class DiamondPrinter {
    private static void printDiamondCore(char character, char stopCharacter){
        if(character == stopCharacter){
            System.out.print(character);
            return;
        }
        System.out.print(character);

        printDiamondCore((char)(character+1), stopCharacter);
        System.out.print(character);
    }

    private static void printDiamond(int diameter){
        if(diameter < 1)
            return;

        // nos aseguramos que diameter no exceda 51 caracteres
        diameter = (diameter <= 2 * 26 - 1) ? diameter : 2 * 26 - 1;
        // distancia desde el centro hasta el punto mas ancho de la linea.
        int radius = diameter / 2;
        for ( int indentation = radius; indentation >= -radius; indentation-- ) {
            int absIndentation = Math.abs( indentation );
            System.out.print( " ".repeat( absIndentation ) );
            printDiamondCore( 'A', (char) ('A' + radius - absIndentation) );
            System.out.println();
        }
    }

    public static void main( String[] args ) {
        //printDiamond(5);
        //printDiamond( 7 );
        //printDiamond( 1 );
        //printDiamond( 0 );
        printDiamond( 200 );
    }
}
