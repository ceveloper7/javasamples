package com.epbs.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Subclass or derived class or child class Assembly
 * Relationship: An Assembly is an Item
 */
public class Assembly extends Part {
    // Relacion de agregacion: Assembly tiene parts
    List<Part> parts;

    private boolean active;
    private int createdBy;
    private LocalDate created;
    private int updatedBy;
    private LocalDate updated;

    public Assembly(int partNo, int internalNo, String name, String description, boolean assembly, boolean active, int createdBy, LocalDate created, int updatedBy, LocalDate updated){
        super(partNo, internalNo, name, description, assembly, active, createdBy, created, updatedBy, updated);
    }
}
