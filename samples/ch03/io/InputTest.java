package ch03.io;

import java.util.*;

public class InputTest{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    System.out.println("Cual es tu nombre? ");
    String name = in.nextLine();

    System.out.println("Cual es tu edad: ");
    int age = in.nextInt();

    System.out.println("Hola, " + name + "el proximo año ud. tendra " + (age + 1) + " años de edad");
  }
}
