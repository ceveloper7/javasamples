package ch03.controlflow;

/**
 *
 */

public class SwitchExpressionWithFallthrough{
  public static void main(String[] args){
    int numLetters;
    String seasonName = "Spring";

    numLetters = switch(seasonName){
      case "Spring":
        System.out.println("Spring time!"); // fallthrough
      case "Summer", "Winter":
        yield 6;
      case "Fall":
        yield  4;
      default:
        yield -1;
    };

    System.out.println(numLetters);
  }
}
