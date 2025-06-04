package com.ceva.ex1.ch02.loops;

import com.ceva.util.Util;

import java.util.Scanner;

/**
 * Loop: Draw board checker
 */
public class Program10 {
    public static void main(String[] args) {
        int width = 0;
        int height = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Checkerboard width: ");
        String vwidth = input.nextLine();


        System.out.print("Checkboard height: ");
        String vheight = input.nextLine();

        try{
            makeChecker(vwidth, vheight);
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }

    }

    private static void makeChecker(String width, String height) throws Exception{
        boolean wv = Util.isDigit(width);
        boolean hv = Util.isDigit(height);

        if(wv && hv){
            int w = Integer.parseInt(width);
            int h = Integer.parseInt(height);
            char hash = '#';
            char guion = '_';

            boolean isGuion = true;

            for(int i = 0; i < h; i++){
                int j = 0;

                while (j < w){
                    if(isGuion){
                        System.out.print(guion);
                        isGuion = false;
                        j++;
                    }else{
                        System.out.print(hash);
                        isGuion = true;
                        j++;
                    }
                }

                isGuion = isGuion ? false : true;
                System.out.println();
            }

        }else{
            throw new Exception("Invalid input");
        }
    }
}
