package com.ceva.ex1.ch05.string;

/**
 * Character and String processing - Check for a good password
 */
public class PasswordTester {
    private static final int MIN_PASSWORD_LEN = 8;

    private static boolean containsUppercaseLetter(String string){
        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if (Character.isUpperCase(c))
                return true;
        }
        return false;
    }

    private static boolean containsLowercaseLetter(String string){
        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if (Character.isLowerCase(c))
                return true;
        }
        return false;
    }

    private static boolean containsDigit(String string){
        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    private static boolean containsSpecialCharacter(String string){
        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if(c == '.' || c == '#' || c == '$' || c == '%' || c == '@' || c == '!' || c == '^' || c == '&' || c == '*')
                return true;
        }
        return false;
    }

    private static boolean isGoodPassword(String password){
        if (password.length() < MIN_PASSWORD_LEN){
            System.err.println("Password is to short");
            return false;
        }

        if(!containsUppercaseLetter(password)){
            System.err.println("Must contain upper case");
            return false;
        }

        if(!containsLowercaseLetter(password)){
            System.err.println("Must contain lower case");
            return false;
        }

        if (!containsDigit(password)){
            System.err.println("Must contain a digit");
            return false;
        }

        if(!containsSpecialCharacter(password)){
            System.err.println("Must contain a special character");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println( isGoodPassword("toshort"));
        System.out.println( isGoodPassword("justlowercase"));
        System.out.println( isGoodPassword("noDigits"));
        System.out.println( isGoodPassword("1specialChar"));
        System.out.println( isGoodPassword("MoreSpec5ialChars.$#&") );
    }
}
