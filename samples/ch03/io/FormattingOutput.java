
package ch03.io;

public class FormattingOutput{
  public static void main(String[] args){
    double number = 10000.0 / 3.0;

    System.out.printf("Formatting wiht two decimals - %8.2f", number);

    System.out.println();
    // Formatting output with flags
    // flag , (comma) agrega separador de grupos
    System.out.printf("Formatting with flags %,.2f", number);
    
  }
}
