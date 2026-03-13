package ch03.controlflow;

/**
 *
 */

public class SwitchStatementWithNoFallthrough{
  public static void main(String[] args){
    int numLetters;
    String seasonName = "Fall";

    switch(seasonName){
      case "Spring" -> {
        System.out.println("Spring time");
        numLetters = 6;
      }
      case "Summer" -> numLetters = 6;
      case "Fall" -> numLetters = 4;
      default -> numLetters = -1;
    }

    System.out.println(numLetters);
  }
}
