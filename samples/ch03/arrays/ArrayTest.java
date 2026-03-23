package ch03.arrays;

import java.util.*;

public class ArrayTest{

  public static void main(String[] args)
  {
    // declaracion de array 1
    int[] numeros = new int[100];

    // declaracion de array 2
    int[] cantidades = {4,2,7,8,9,1};
    String[] nombres = {"Jose", "Pedro", "Maria"};

    // for each looping
    for(int n : cantidades){
      System.out.println(n);
    }

    for(String name : nombres){
      System.out.println(name);
    }

    // copiando arrays
    String[] names = Arrays.copyOf(nombres, 2 * nombres.length);

    for(String n : names){
      System.out.println(n);
    }

    // sorting arrays
    Arrays.sort(cantidades);

    for(int c : cantidades){
      System.out.println(c);
    }
  }
}
