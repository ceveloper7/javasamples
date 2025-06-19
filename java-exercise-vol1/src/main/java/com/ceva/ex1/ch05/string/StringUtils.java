package com.ceva.ex1.ch05.string;

/**
 * Counts how many times the substring appears in the larger string.
 *
 * A {@code null} or empty ('') String input returns {@code 0}.
 *
 * <pre>
 * StringUtils.countMatches(null, *)  = 0
 * StringUtils.countMatches('', *)  = 0
 * StringUtils.countMatches('abba', null) = 0
 * StringUtils.countMatches('abba', '') = 0
 * StringUtils.countMatches('abba', 'a') = 2
 * StringUtils.countMatches('aaaa', 'aa') = 2
 * StringUtils.countMatches('abba', 'ab') = 1
 * StringUtils.countMatches('abba', 'xxx') = 0
 * </pre>
 *
 * @param string  the String to check maybe null
 * @param other   the substring to count maybe null
 * @return the number of occurrences, 0 if either String is {@code null}
 */

public class StringUtils {
    private static final int INDEX_NOT_FOUND = -1;

    private static int countMatcher(String string, String other){
        if(string == null || other == null || string.isEmpty() || other.isEmpty()){
            return 0;
        }

        int result = 0;

        for(int index = 0; (index = string.indexOf(other, index)) != INDEX_NOT_FOUND; index += other.length()){
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        String cadena = "Java";
        String subCadena = "a";
        System.out.printf("(%s, %s) -> %d", cadena, subCadena, countMatcher(cadena, subCadena));
    }
}
