package com.ceva.ex1.ch05.string;

/**
 * Character and String processing - Constraint Line Boundaries and Wrap Lines
 */
public class WordWrap {

    private static String wrap(String string, int width){
        if (string.length() <= width)
            return string;

        int breakIndex = string.lastIndexOf(" ", width);
        if (breakIndex == -1)
            breakIndex = width;

        String firstLine = string.substring(0, breakIndex);
        String remaining = wrap(string.substring(breakIndex).trim(), width);

        return firstLine + '\n' + remaining;
    }

    public static void main(String[] args) {
        String s = "Live now; make now always the most precious time. " + "Now will never come again.";
        System.out.println(wrap(s, 30));
    }
}
