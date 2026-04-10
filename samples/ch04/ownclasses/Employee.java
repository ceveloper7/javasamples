package ch04.ownclasses;

import java.time.*;

public class Employee{
  private String name;
  private double salary;
  private LocalDate hireDay;

  public Employee(String name, double salary, int year, int month, int day){
    this.name = name;
    this.salary = salary;
    this.hireDay = LocalDate.of(year, month, day);
  }

  public String getName(){
    return this.name;
  }

  public double getSalary(){
    return this.salary;
  }

  public LocalDate getHireDay(){
    return this.hireDay;
  }

  public void raiseSalary(double byPercent){
    double raiseSalary = salary * (byPercent / 100);
    salary += raiseSalary;
  }

  public static void main(String[] args){
    Employee[] staff = new Employee[3];

    staff[0] = new Employee("Fernando", 100000, 1980, 10, 22);
    staff[1] = new Employee("Maria Eugenia", 75000, 1990, 7, 15);
    staff[2] = new Employee("Jorge", 120000, 2000, 11, 5);

    for(Employee e : staff){
      e.raiseSalary(5);
    }

    for(Employee e : staff){
      System.out.println("name = " + e.getName() + ", salary = " + e.getSalary() + ", hireDay = " + e.getHireDay());
    }
  }
}
