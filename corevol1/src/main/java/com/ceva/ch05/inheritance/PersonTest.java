package com.ceva.ch05.inheritance;

import com.ceva.ch04.classes_objects.model.Employee;

import java.util.Arrays;

public class PersonTest {
    public static void main(String[] args) {
        var people = new Person[2];

        // llenamos el array people con objetos Student y Employee
        people[0] = new Student("Maria Morris", "Computer Science");
        people[1] = new Employee("Harri Hacker", 50000, 1989,10,1);

        Arrays.stream(people).forEach(System.out::println);
    }
}
