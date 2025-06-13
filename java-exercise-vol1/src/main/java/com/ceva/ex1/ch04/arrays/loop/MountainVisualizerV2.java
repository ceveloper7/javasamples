package com.ceva.ex1.ch04.arrays.loop;

public class MountainVisualizerV2 {
    private static char mountainChar(int[] altitudes, int index){
        int previous = index == 0 ? 0 : altitudes[index- 1];
        int current = altitudes[ index ];
        int next     = index < altitudes.length - 1 ? altitudes[ index + 1 ] : -1;

        if ( previous < current && current > next )
            return '^';
        if ( current < next )
            return '/';
        if ( current > next )
            return '\\';
        return '-';
    }

    public static void printMountain( int[] altitudes ) {
        if ( altitudes.length == 0 )
            return;

        int maxAltitude = altitudes[ 0 ];

        for ( int altitude : altitudes )
            if ( altitude > maxAltitude )
                maxAltitude = altitude;

        for ( int height = maxAltitude; height >= 0; height-- ) {
            System.out.print( height + " " );
            for ( int x = 0; x < altitudes.length; x++ )
                System.out.print( altitudes[ x ] == height ? mountainChar( altitudes, x ) : ' ' );
            System.out.println();
        }
    }

    public static void main( String[] args ) {
        int[] mountain = { 0, 1, 1, 2, 2, 3, 3, 3, 4, 5, 4, 3, 2, 2, 1, 0 };
        printMountain( mountain );
    }
}
