package org.ceva.ch07.generics;

/**
 * Clase normal con metodos genericos
 */
public class Utilities_01 {

    // cuando la clase no es generic, es necesario inidcar en la firma del metodo que el metodo es generic
    public static <T> void printGenericValue(T vaue){
        System.out.println(vaue);
    }

    public static <K, V> void printKeyValue(K key, V value){
        System.out.println("Key: " + key + " - Value: " + value );
    }
}
