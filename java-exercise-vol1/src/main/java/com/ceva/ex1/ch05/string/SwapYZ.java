package com.ceva.ex1.ch05.string;

/**
 * String: Swap Y and Z
 */
public class SwapYZ {
    // using if condition
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

    // using switch
    private static void printSwappedYZ2(String string){
        for (int i = 0; i < string.length(); i++){
            switch (string.charAt(i)){
                case 'y' :
                    System.out.print('z') ; break;
                case 'z' :
                    System.out.print('y'); break;
                case 'Y' : System.out.print('Z'); break;
                case 'Z' : System.out.print('Y'); break;
                default: System.out.print(string.charAt(i));
            }
        }
    }

    // using nested condition
    private static void printSwappedYZ3(String string){
        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            System.out.print(c == 'y' ? 'z' :
                             c == 'z' ? 'y' :
                             c == 'Y' ? 'Z' :
                             c == 'Z' ? 'Y' :
                             c);
        }
    }

    // using switch expression
    private static void printSwappedYZ4(String string){
        for(int i = 0; i < string.length(); i++){
            switch (string.charAt(i)){
                case 'y' -> System.out.print('z');
                case 'z' -> System.out.print('y');
                case 'Y' -> System.out.println('Z');
                case 'Z' -> System.out.println('Y');
                default -> System.out.print(string.charAt(i));
            }
        }
    }

    private static void printSwappedYZ5(String string){
        for(int i = 0; i < string.length(); i++){
            System.out.print(
                    switch (string.charAt(i)){
                        case 'y' -> 'z';
                        case 'z' -> 'y';
                        case 'Y' -> 'Z';
                        case 'Z' -> 'Y';
                        default -> string.charAt(i);
                    }
            );
        }
    }

    public static void main(String[] args) {
        printSwappedYZ5("yootaxz");
    }
}
