package ch03.controlflow;

/**
 * Switch Expression sample
 */

public class Switch{
  public static void main(String[] args){
    int seasonCode = 2;
    String seasonName = switch(seasonCode){
      case 0 -> "Spring";
      case 1 -> "Summer";
      case 2 -> "Fall";
      case 3 -> "Winter";
      default -> "???";  
    };

    System.out.println(seasonName);
  }
}
