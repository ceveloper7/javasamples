package com.ceva.ex1.ch02.expressions_operands_operators;

/**
 * One bottle of Rum, Ten bottles of Rum
 */
public class Program4 {
    private static final String SINGULAR = "bottle";
    private static final String PLURAL = "bottles";

    public static void main(String[] args) {
        int nroOfBottles = 99;

        if(nroOfBottles > 1){
            System.out.println(nroOfBottles + " " + PLURAL + " of rum");
        }else if(nroOfBottles == 0){
            System.out.println(nroOfBottles + " " + PLURAL + " of rum");
        }else{
            System.out.println(nroOfBottles + " " + SINGULAR + " of rum");
        }
    }
}
