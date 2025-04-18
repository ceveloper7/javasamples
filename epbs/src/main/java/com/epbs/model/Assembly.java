package com.epbs.model;

import java.util.List;

/**
 * Subclass or derived class or child class Assembly
 * Relationship: An Assembly is an Item
 */
public class Assembly extends Part {

    public Assembly(int partNo, int internNo, String name, String description, boolean isAnAssembly){
        super(partNo, internNo, name, description, isAnAssembly);
    }
    List<Part> parts;
}
