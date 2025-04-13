package org.ceva.ch03.fundamentals;

import java.io.StringWriter;

public class AB_String {
    public static void main(String[] args) {
        stringEquality();
    }

    private static void stringEquality(){
        String str1 = "EJC 2000 Loader";
        String str2 = new String(str1);
        String str3 = "EJC 2000 Loader";

        System.out.println("str1.equals(str2) returns " + str1.equals(str2));
        System.out.println("str1 == str2 return " + (str1 == str2));
        System.out.println("str1.equals(str3) returns " + str1.equals(str3));
        System.out.println("str1 == str3 returns " + (str1 == str3));
    }

    private static void stringComparing(){
        String s1 = new String("hello");
        String s2 = "goodbye";
        String s3 = "Happy Birthday";
        String s4 = "happy birthday";

        // test CompareTo
        System.out.printf("%ns1.compareTo(s2) is %d", s1.compareTo(s2));
        System.out.printf("%ns2.compareTo(s1) is %d", s2.compareTo(s1));
        System.out.printf("%ns1.compareTo(s1) is %d", s1.compareTo(s1));
        System.out.println();

        /**
         * toffset => start index del objeto string que invoca el metodo
         * String -> String a comparar
         * oofset -> start index de objeto string a comparar
         * len -> numero de caracteres a comparar entre los dos string
         */
        if(s3.regionMatches(0, s4, 0, 5)){
            System.out.println("First 5 characters of s3 and s4 match");
        }else{
            System.out.println("First 5 characters of s3 and s4 do not match");
        }

        if(s3.regionMatches(true, 0, s4, 0, 5)){
            System.out.println("First 5 characters of s3 and s4 match with case ignored");
        }else{
            System.out.println("First 5 characters of s3 and s4 do not match");
        }
    }
}
