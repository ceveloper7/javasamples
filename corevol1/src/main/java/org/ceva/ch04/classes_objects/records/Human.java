package org.ceva.ch04.classes_objects.records;

public record Human(String name, int age, float height) {

    public Human(){
        this("Unknown", 0, 0f);
    }
}
