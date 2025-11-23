package com.ceva.ch01.fromromans;

import com.ceva.ch01.exceptions.InvalidRomanNumeralException;

import java.util.Arrays;

public class FromRomanV3 {

    private static String replaceDigraphs(String roman) {
        roman = roman.replace("IV", "4");
        roman = roman.replace("IX", "9");
        roman = roman.replace("XL", "F");
        roman = roman.replace("XC", "N");
        roman = roman.replace("CD", "G");
        roman = roman.replace("CM", "O");
        return roman;
    }

    private static void checkForImproperRepetitions(String roman) {
        if (roman.contains("IIII") ||
                roman.contains("VV") ||
                roman.contains("XXXX") ||
                roman.contains("LL") ||
                roman.contains("CCCC") ||
                roman.contains("DD") ||
                roman.contains("MMMM")) {
            throw new InvalidRomanNumeralException(roman);
        }
    }

    private static void checkForIllegalPrefixCombinations(String roman) {
        if (roman.contains("VIV") ||
                roman.contains("IVI") ||
                roman.contains("IXI") ||
                roman.contains("LXL") ||
                roman.contains("XLX") ||
                roman.contains("XCX") ||
                roman.contains("DCD") ||
                roman.contains("CDC") ||
                roman.contains("MCM")) {
            throw new InvalidRomanNumeralException(roman);
        }
    }

    private static void checkNumbersAreInOrder(int[] numbers, String roman){
        int lastDigit = 1000;
        for (int number : numbers) {
            if (number > lastDigit) {
                throw new InvalidRomanNumeralException(roman);
            }
            lastDigit = number;
        }
    }

    private static int[] convertLettersToNumbers(String roman) {
        int[] numbers = new int[roman.length()];
        int i = 0;
        for (char digit : roman.toCharArray()) {
            switch (digit) {
                case 'I' -> numbers[i] = 1;
                case 'V' -> numbers[i] = 5;
                case 'X' -> numbers[i] = 10;
                case 'L' -> numbers[i] = 50;
                case 'C' -> numbers[i] = 100;
                case 'D' -> numbers[i] = 500;
                case 'M' -> numbers[i] = 1000;
                case '4' -> numbers[i] = 4;
                case '9' -> numbers[i] = 9;
                case 'F' -> numbers[i] = 40;
                case 'N' -> numbers[i] = 90;
                case 'G' -> numbers[i] = 400;
                case 'O' -> numbers[i] = 900;
                default -> throw new InvalidRomanNumeralException(roman);
            }
            i++;
        }
        return numbers;
    }

    public static int convert(String roman){
        checkForIllegalPrefixCombinations(roman);
        checkForImproperRepetitions(roman);
        roman = replaceDigraphs(roman);
        int[] numbers = convertLettersToNumbers(roman);
        checkNumbersAreInOrder(numbers, roman);
        return Arrays.stream(numbers).sum();
    }
}
