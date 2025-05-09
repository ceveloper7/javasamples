package org.ceva.ch06.interfaces.two;

import org.ceva.ch04.classes_objects.model.Employee;
import org.ceva.ch05.inheritance.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Creating Comparators
 */
public class Program2 {
    public static void main(String[] args) {
        List<Employee> payroll = Employee.payroll();

        //payroll.sort(Comparator.comparing(Employee::getSalary));
        //payroll.sort(Comparator.comparing(Person::getName));
        //payroll.sort(Comparator.comparing(Person::getName, Comparator.comparingInt(String::length)));
        //payroll.sort(Comparator.comparingInt(p -> p.getName().length()));

        payroll.forEach(System.out::println);
    }
}
