package  ch03.controlflow;

/**
 *
 * 
 */

public class SwitchExpressionWithNoFallthrough{
  public static void main(String[] args){
    String seasonName = "Summer";

    int numLetters = switch(seasonName){
      // yield y llaves evitan el fallthrough en switch expression
      case "Spring" -> {
          System.out.println("spring time!");
          yield 6;  
      }
      case "Summer", "Winter" -> 6; // cada branch con switch expression retorna una valor
      case "Fall" -> 4;
      //case "Fall":  yield 4; // otra forma branch con switch expression valido pero no se puede mezaclar una forma y otra
      default -> -1;
    };

    System.out.println(numLetters);
  }
}
