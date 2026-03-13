package ch03.controlflow;

import java.util.*;

/**
 * Multiple selection with switch
 */


public class Switch1{

  private static int getOption(){
    System.out.println("Menu System");
    System.out.println("Option 1");
    System.out.println("Option 2");
    System.out.println("Option 3");
    System.out.println("Option 4");
    
    Scanner input = new Scanner(System.in);
    System.out.print("Select an option (1,2,3,4) ");
    int opt = input.nextInt();

    return opt;
  }

  private static void switchV1(int opt){
    switch(opt){
      case 1 -> System.out.println("Option 1");
      case 2 -> System.out.println("Option 2");
      case 3 -> System.out.println("Option 3");
      case 4 -> System.out.println("Option 4");
      default -> System.out.println("Option not accepted");  
    }
  }

  public static void main(String[] args){
    switchV1(getOption());
  }
}
