package com.epbs.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Subclass or derived class or child class Assembly
 * Relationship: An Assembly is an Item
 */
public class Assembly extends Part {

    List<Part> parts;

    private boolean isActive;
    private int createdBy;
    private LocalDate created;
    private int updatedBy;
    private LocalDate updated;

    public Assembly(int partNo, int internNo, String name, String description, boolean isAnAssembly){
        super(partNo, internNo, name, description, isAnAssembly);
    }
}
