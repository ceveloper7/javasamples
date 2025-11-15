package com.ceva.ch01.fromromans;

import com.ceva.ch01.exceptions.InvalidRomanNumeralException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FromRomanV2 {

    private String roman;
    private List<Integer> numbers = new ArrayList<>();
    private int charIx;
    private char nextChar;
    private Integer nextValue;
    private Integer value;
    private int nchars;

    Map<Character, Integer> values = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

    public FromRomanV2(String roman) {
        this.roman = roman;
    }

    public static int convert(String roman) {
        return new FromRomanV2(roman).doConversion();
    }

    private int doConversion() {
        checkInitialSyntax();
        convertLettersToNumbers();
        checkNumbersInDecreasingOrder();
        return numbers.stream().reduce(0, Integer::sum);
    }

    private void checkInitialSyntax() {
        checkForIllegalPrefixCombinations();
        checkForImproperRepetitions();
    }

    private void checkForIllegalPrefixCombinations() {
        checkForIllegalPatterns(
                new String[]{"VIV", "IVI", "IXI", "IXV", "LXL", "XLX",
                        "XCX", "XCL", "DCD", "CDC", "CMC", "CMD"});
    }

    private void checkForImproperRepetitions() {
        checkForIllegalPatterns(
                new String[]{"IIII", "VV", "XXXX", "LL", "CCCC", "DD", "MMMM"});
    }

    private void checkForIllegalPatterns(String[] patterns) {
        for (String badString : patterns)
            if (roman.contains(badString))
                throw new InvalidRomanNumeralException(roman);
    }

    private void convertLettersToNumbers() {
        char[] chars = roman.toCharArray();
        nchars = chars.length;
        for (charIx = 0; charIx < nchars; charIx++) {
            nextChar = isLastChar() ? 0 : chars[charIx + 1];
            nextValue = values.get(nextChar);
            char thisChar = chars[charIx];
            value = values.get(thisChar);
            switch (thisChar) {
                case 'I' -> addValueConsideringPrefix('V', 'X');
                case 'X' -> addValueConsideringPrefix('L', 'C');
                case 'C' -> addValueConsideringPrefix('D', 'M');
                case 'V', 'L', 'D', 'M' -> numbers.add(value);
                default -> throw new InvalidRomanNumeralException(roman);
            }
        }
    }

    private boolean isLastChar() {
        return charIx + 1 == nchars;
    }

    private void addValueConsideringPrefix(char p1, char p2) {
        if (nextChar == p1 || nextChar == p2) {
            numbers.add(nextValue - value);
            charIx++;
        } else numbers.add(value);
    }

    private void checkNumbersInDecreasingOrder() {
        for (int i = 0; i < numbers.size() - 1; i++)
            if (numbers.get(i) < numbers.get(i + 1))
                throw new InvalidRomanNumeralException(roman);
    }

    public static class InvalidRomanNumeralException extends RuntimeException {
        public InvalidRomanNumeralException(String roman) {
            super("Invalid Roman numeral: " + roman);
        }
    }
}
