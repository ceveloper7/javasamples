package com.ceva.ex1.ch02.loops;

/**
 * Loop: A flag in the wind through Nested Loop
 */
public class Program9 {
    public static void main(String[] args) {

        for(int i = 1; i <= 5; i++){
            int count = 0;
            while(count < i){
                System.out.print(" " + i);
                count++;
            }
            System.out.println();
        }
    }
}
