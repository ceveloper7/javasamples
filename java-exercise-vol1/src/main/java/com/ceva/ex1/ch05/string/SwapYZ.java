package com.ceva.ex1.ch05.string;

/**
 * String: Swap Y and Z
 */
public class SwapYZ {
    private static void printSwappedYZ1(String string){
        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);

            if (c == 'y')
                c = 'z';
            else if (c == 'z')
                c = 'y';
            else if (c == 'Y')
                c = 'Z';
            else if (c == 'Z')
                c = 'Y';
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        printSwappedYZ1("yootaxz");
    }
}
