package ch03.controlflow;

/**
 *
 *
 */

public class SwitchStatementWithFallthrough{
  public static void main(String[] args){
    int numLetters;
    String seasonName = "Spring";

    switch (seasonName) {
      case "Spring":
        System.out.println("Spring time!"); // fallthrough
      case "Summer", "Winter":
        numLetters = 6;
        break;
      case "Fall":
        numLetters = 4;
        break; 
      default:
        numLetters = -1;
    }

    System.out.println(numLetters);
  }
}
