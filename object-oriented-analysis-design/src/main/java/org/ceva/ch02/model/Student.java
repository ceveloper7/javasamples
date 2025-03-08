package org.ceva.ch02.model;

public class Student {
    private String name;
    private String address;

    // promedio de calificaciones
    private double gpa;

    // Una sola instancia del atributo minimunGPA en toda la aplicacion
    private static double minimunGPA;

    public Student(String name){
        this.name = name;
    }

    public Student(String name, String address){
        this.name = name;
        this.address = address;
    }

    public Student(){}

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static void setMinimunGPA(double newMinimunGPA){
        minimunGPA = newMinimunGPA;
    }

    public static double getMinimunGPA(){
        return minimunGPA;
    }
}
