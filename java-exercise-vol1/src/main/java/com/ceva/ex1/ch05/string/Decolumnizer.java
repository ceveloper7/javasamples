package com.ceva.ex1.ch05.string;

public class Decolumnizer {

    private static final int COLUMN_NOT_FOUND = -1;

    // verificamos si hay un espacio en la posicion index
    private static boolean isSpaceAt(String string, int index){
        if(index >= string.length())
            return true;

        return string.charAt(index) == ' ';
    }

    private static int findColumnIndex(String[] lines){
        int length = lines[0].length();

        // encontramos la linea con mayor longitud
        for(String line : lines){
            length = Math.max(length, line.length());
        }
        // recorremos todas las columnas posibles
        mainLoop:
        for(int colum = 1; colum < length -1; colum++){
            // para cada columna se examina todas las filas posibles.
            for(String line : lines)
                if(!isSpaceAt(line, colum))
                    // pasamos a la siguiente iteracion del bucle externo
                    continue mainLoop;
            return colum;
        }
        return COLUMN_NOT_FOUND;
    }

    private static void decolumnize(String string){
        String[] lines = string.split("\n");
        if (lines.length < 2)
            return;

        int column = findColumnIndex(lines);
        if(column == COLUMN_NOT_FOUND){
            System.out.println(string);
            return;
        }

        // columna izquierda
        for(String line : lines){
            int a = line.length();
            System.out.println(line.substring(0, ( a <= column)? a : column).trim());
        }

        // Right column
        for ( String line : lines )
            if ( column < line.length() )
                System.out.println( line.substring( column + 1 ).trim() );
            else
                System.out.println();
    }

    public static void main(String[] args) {
        String text, text1;
        text = "I’m dishonest, and a to watch out for,\n" +
                "dishonest man you    because you can.";

        text1 = "dish. are\n"+
                "hon ones";

        System.out.println(text + "\n==>");
        decolumnize(text);
    }
}
