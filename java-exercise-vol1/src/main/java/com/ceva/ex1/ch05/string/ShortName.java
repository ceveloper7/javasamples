package com.ceva.ex1.ch05.string;

/**
 * Character and String processing: Find the Shortest name in the array
 */
public class ShortName {
    private static final int SPACE_NOT_FOUND = -1;

    private static String shortest(String s1, String s2){
        return s1.length() <= s2.length() ? s1 : s2;
    }

    private static String shortestName(String... names){
        if(names.length == 0)
            return "";

        String result = names[0];
        for (String name : names){
            // Ubicacion del espacio en la cadena
            int spacePos = name.indexOf(" ");
            // Validamos si no hay espacio en la cadena
            if(spacePos == SPACE_NOT_FOUND){
                // obtenemos la cadena mas corta
                result = shortest(result, name);
            }else{
                // name has spaces, dividimos el nombre en dos partes
                String part1 = name.substring(0, spacePos);
                String part2 = name.substring(spacePos+1);
                // primero, determinar la cadena mas corta entre part1 y part2, luego comparar la cadena mas corta con result
                // para identificar la cadena mas corta.
                result = shortest(result, shortest(part1, part2));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(shortestName("Albert Tross", "Blowfish", "Nick Olaus", "Jo Ker", "J Jay"));
    }
}
