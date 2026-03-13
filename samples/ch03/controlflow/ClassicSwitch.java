package ch03.controlflow;

/**
 * Classic switch form
 */

public class ClassicSwitch{
  public static void main(String[] args){
    int codeOpt = 2;

    switch(codeOpt){
      case 1:
        System.out.println("opt " + codeOpt);
        break;
      case 2:
        System.out.println("opt " + codeOpt);
        break;
      case 3:
        System.out.println("opt " + codeOpt);
        break;
      case 4:
        System.out.println("opt " + codeOpt);
        break;
      default:
        System.out.println("option invalid...");
    };
  }
}
