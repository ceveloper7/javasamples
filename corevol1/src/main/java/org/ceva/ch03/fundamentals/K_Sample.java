package org.ceva.ch03.fundamentals;

import java.util.List;

public class K_Sample {
    public static void main(String[] args) {
        List<String> list = List.of("1", "a", "2", "a","3", "a");

        list.forEach((item) -> {
            if (item.equals("a")){
                System.out.println("Equals to a");
            }else{
                System.out.println("Not a");
            }
        });
    }
}
