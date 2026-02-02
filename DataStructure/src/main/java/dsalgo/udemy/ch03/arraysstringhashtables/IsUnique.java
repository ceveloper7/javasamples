package dsalgo.udemy.ch03.arraysstringhashtables;

import java.util.HashSet;
import java.util.Set;

/**
 * Dado un metodo que recibe un STring, comprobar si todos los caracteres son unicos o no
 * isUnique("abcde") => true
 * isUnique("abcded") => false
 *
 * Con una tabla hash se mejora la complejidad a Big O(N)
 */
public class IsUnique {

    private static final int NUMBER_OF_CHARS = 128;

    public static boolean isUnique(String s){
        // Si supera los 128 caracteres, definitivamente hay caracteres repetidos
        if(s.length() > NUMBER_OF_CHARS)
            return false;

        // Por cada caracters hacemos la comprobacion en el Set
        Set<Character> characters = new HashSet<>();
        for (Character c : s.toCharArray()){
            if(characters.contains(c)) return false;
            characters.add(c);
        }
        return true;
    }
}
