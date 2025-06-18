package com.ceva.ex1.ch05.string;

/**
 * Character and String: Testing for Palindrome property
 */
public class PalindromeTester {
    private static boolean isPalindrome(String string){
        for(int i = 0; i < string.length() / 2; i++ ){
            char frontChar = string.charAt(i);
            char backChar = string.charAt(string.length() - i - 1);
            if(frontChar != backChar)
                return false;
        }
        return true;
    }

    private static boolean isPalindromeIgnoringCase(String string){
        return isPalindrome(string.toLowerCase());
    }

    // palindromo, ignoramos caracteres que no sean letras y digitos
    private static boolean isPalindromeIgnoringNonLettersAndDigits(String string){
        for(int startIndex = 0, endIndex = string.length()-1; startIndex < endIndex; startIndex++,endIndex--){
            while (Character.isLetterOrDigit(string.charAt(startIndex))){
                startIndex++;
            }
            while (!Character.isLetterOrDigit(string.charAt(endIndex))){
                endIndex--;
            }

            char frontChar = Character.toLowerCase(string.charAt(startIndex));
            char backChar = Character.toLowerCase(string.charAt(endIndex));

            if(frontChar != backChar)
                return false;
        }
        return true;
    }

    private static boolean isPalindromeRecursive(String string){
        if (string.length() < 2)
            return true;

        if(string.charAt(0) != string.charAt(string.length()-1))
            return false;

        return isPalindromeRecursive(string.substring(1, string.length()-1));
    }

    private static boolean isPalindromeV2(String string){
        return new StringBuilder(string).reverse().toString().equals(string);
    }

    private static boolean isPalindromeV3(String string){
        return string.contentEquals(new StringBuilder(string).reverse());
    }

    public static void main(String[] args) {
        System.out.println("Radar? " + isPalindromeV3("radar"));
    }
}
