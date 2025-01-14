package com.ceva.ch05.inheritance;

import com.ceva.ch04.classes_objects.model.Employee;

import java.util.Objects;

/*
 * 5.1 Classes, Superclasses, Subclasses,
 * extends -> permite aplicar el concepto de herencia, definiendo una subclase
 *            Superclass or Parent class-> Employee
 *            Subclass or Child class-> Manager
 * Cada objeto Manager (no al clase Manager) tiene 4 campos de instancia: name, salary, hireDay, bonus
 * los atributos name, salary, hireDay son tomados de su super clase Employee.
 */
public class Manager extends Employee {
    // adicionamos variables y metodos de instancia a una subclass
    private double bonus;

    // subclass constructor. supper tiene dos significados.
    // 1. Permite llamar al constructor de la super clase
    // 2. Permite llamar a un metodo de la super clase.
    public Manager(String name, double salary, int year, int month, int day){
        // Llamamos al constructor de la super clase Employee
        super(name, salary, year, month, day);
        this.bonus = 0;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public double getBonus(){
        return bonus;
    }

    /*
     * Sobrescribimos el metodo getSalary de la Superclass Employee
     *  El salario de la subclase Manager consiste en baseSalary + bonus
     * supper es una keyword de java que dirige al compilador a invocar un metodo de la superclass
     */
    @Override
    public double getSalary() {
        // super.getSalary() llamamos al metodo getSalary() de la Superclass Employee
        var salary = super.getSalary();
        return salary + this.bonus;
    }

    @Override
    public boolean equals(Object otherObject){
        if(!super.equals(otherObject))return  false;
        var other = (Manager) otherObject;
        return this.bonus == other.bonus;
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), bonus);
    }

    @Override
    public String toString() {
        return
                super.toString() +
                        "[bonus=" + bonus + "]";
    }
}
