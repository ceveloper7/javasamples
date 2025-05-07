package com.ceva.ex1.ch02.control_flow;

/**
 *
 */
public class Program4 {
    public static void main(String[] args) {
        if (true) {
            // al ser false, el bloque interno no se ejecuta, por li qe se ejecuta bloque else
            if (false)
                if (3!=4)
                    ;
                else
                    System.out.println("kkkkk");
            else
                System.out.println("uuuuu");
        }
    }

}
