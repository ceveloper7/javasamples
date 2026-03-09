package ch03.io;

import java.util.*;

public class InputFormattingOutput{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    System.out.println("Cual es tu nombre? ");
    String name = in.nextLine();

    System.out.println("Cual es tu edad? ");
    int age = in.nextInt();

    System.out.printf("Hola %s, el proximo año ud. tendra %d años", name, (age + 1));

    // Creating a nuew String Formatting
    String format = String.format("Name: %s, age %d", name, age);
    System.out.println(format);
  }
}
