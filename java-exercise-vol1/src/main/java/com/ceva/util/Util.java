package com.ceva.util;

public class Util {
    public static boolean isDigit(String input){
        return input.matches("[0-9]{1,13}(\\.[0-9]*)?");
    }
}
