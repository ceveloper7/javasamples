package com.ceva.ex1.ch04.arrays.varargs;

/**
 * Arrays: variable argument list
 */
public class AllTrue {
    private static boolean allTrue(boolean first, boolean... remaining){
        for (boolean b : remaining)
            if (b == false)
                return false;

        return first;
    }

    public static void main(String[] args) {
        System.out.println("1. " + allTrue(true, true, true));
        System.out.println("2. " + allTrue(false, true, true));
        System.out.println("3. " + allTrue(true));
        System.out.println("4. " + allTrue(true, false));
        System.out.println("5. " + allTrue(true, null)); // throws an exception
        //System.out.println("6. " + allTrue());
    }
}
