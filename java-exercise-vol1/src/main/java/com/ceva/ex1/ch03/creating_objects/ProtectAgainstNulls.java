package com.ceva.ex1.ch03.creating_objects;

public class ProtectAgainstNulls {
    public static void main(String[] args) {
        String cadena= "";

        // lanza nullpointer exception
//        if(!cadena.isEmpty() && cadena !=  null){
//            System.out.println("todo ok");
//        }else{
//            System.out.println("Nullpointer Exception");
//        }

        // lanza nullpointer exception
//        if (cadena != null & !cadena.isEmpty()){
//            System.out.println("todo ok");
//        }else {
//            System.out.println("nullpointer exception");
//        }

        // verificacion correcta. evitamos el NUllPointerException
        if(cadena != null && !cadena.isEmpty()){
            System.out.println("verificacion ok");
        }else{
            System.out.println("error");
        }
    }
}
