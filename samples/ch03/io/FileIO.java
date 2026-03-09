package ch03.io;

import java.nio.file.Path;
import java.util.*;
import java.io.IOException;

public class FileIO{
  public static void main(String[] args) throws IOException{
    Scanner myFile = new Scanner(Path.of(System.getProperty("user.home") + "/test.txt"));

    while(myFile.hasNext()){
      String row = myFile.nextLine();
      System.out.println(row);
    }
  }
}


