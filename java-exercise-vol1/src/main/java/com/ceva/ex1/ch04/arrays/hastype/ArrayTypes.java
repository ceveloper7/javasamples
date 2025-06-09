package com.ceva.ex1.ch04.arrays.hastype;

public class ArrayTypes {
    public static void main(String[] args) {
        // compiler knows is a string array
        String[] strings = new String[100];

        // type conversion is irrelevant because String[] es un subtipo de Object[]
        Object[] a1 = (String[]) strings;

        // type conversion is implicit.
        Object[] a2 = strings;

        // Runtime environment knows there is a String array in memory. But compiler knows String array only as a Object array
        // implicit type converison
        Object[] string2 = new String[]{"1","2","3"};

        // upgrade an Object array to String array . it works
        String[] a3 = (String[]) string2;

        // build a String array and declare it as a String array. is a usual notation.
        String[] string3 = {"1","2","3"};

        // implicit type conversion from String array to Object array. it works
        Object[] a4 = string3;

        // the compiler doesnt build a String array but buil an Object array and put STring references into Object array
        // there is no STring array, only Object array that references strings.
        Object[] strings4 = {"1","2","3"};

        // compiler accepts this cast an Object array to String array. but at runtime environmet knows the variable string4
        // holds a Object array and not a STring array and throws an exception.
        String[] a5 = (String[]) strings4;

        // it works
        int[] ints1 = new int[100];

        // int array can not be converted to Object array in a explicti way
        //Object[] a6 = (int[]) ints1;

        // int array can not be converted to Object array in a implicit way
        //Object[] ints2 = new int[100];

        // error, types not matching
        //int[] a7 = (int[]) ints2;
    }
}
