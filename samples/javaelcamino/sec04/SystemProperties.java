package sec04;

import java.util.Properties;

public class SystemProperties{
  public static void main(String[] args){
    Properties props = System.getProperties();
    for(String prop : props.stringPropertyNames()){
      System.out.println(prop + " = " + System.getProperty(prop));
    }
  }
}
