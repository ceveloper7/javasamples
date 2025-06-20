package com.ceva.ex1.ch05.string;

/**
 * Character and String processing: Determine the Larger Crew Size
 */
public class CrewSize {
    private static void printDecodedCrewSize(String string) throws IllegalArgumentException{
        int index = string.indexOf('-');
        if(index < 0)
            throw new IllegalArgumentException("Separator - is missing in " + string);

        System.out.print(string + " ==> ");
        int diff = 2 * index - (string.length() - 1);
        switch (Integer.signum(diff)){
            case -1 -> System.out.printf("Raided ship had a larger crew, difference %d%n", -diff);
            case 0 -> System.out.println("Ships had the same crew size");
            case +1 -> System.out.printf("Pirate ship had a larger crew, difference %d%n", diff);
        }
    }

    public static void main(String[] args) {
        printDecodedCrewSize("|-||");
    }
}
