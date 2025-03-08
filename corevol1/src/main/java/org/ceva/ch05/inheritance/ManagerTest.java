package org.ceva.ch05.inheritance;

import org.ceva.ch04.classes_objects.model.Employee;

public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("Carl Cracker", 80000, 1987,12,15);
        boss.setBonus(5000);

        // Todos los elementos del array staff son de tipo Employee
        Employee[] staff = new Employee[3];
        staff[0] = boss;
        // staff[0].setBonus(500) ERROR

        staff[1] = new Employee("Harry Hacker", 50000, 1989,10,1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        // e de tipo Employee
        for(Employee e : staff){
            System.out.println(e);
        }
    }
}
