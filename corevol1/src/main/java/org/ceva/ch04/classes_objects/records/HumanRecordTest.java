package org.ceva.ch04.classes_objects.records;

public class HumanRecordTest {
    public static void main(String[] args) {
        Human john = new Human("John Mayer", 47, 1.9f);

        System.out.println("John as string: " + john);
        System.out.println("John's hashCode: " + john.hashCode());
        System.out.println("John's name: " + john.name());
    }
}
