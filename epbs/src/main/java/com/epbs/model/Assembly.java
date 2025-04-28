package com.epbs.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Subclass or derived class or child class Assembly
 * Relationship: An Assembly is a Part. each Assembly object is an object of the Superclass Part.
 */
public class Assembly extends Part{
//    private int id;
//    private String partNo;
//    private String name;
//    private String description;

    private boolean topLevel;
    private Manufacturer manufacturer;

//    private boolean active;
//    private int createdBy;
//    private LocalDate created;
//    private int updatedBy;
//    private LocalDate updated;

    public Assembly(){
        super();
        this.topLevel = false;
        this.manufacturer = null;
    }

    public Assembly(int partNo, String name, String description, boolean active,  int createdBy, LocalDate created, int updatedBy, LocalDate updated,  boolean topLevel, Manufacturer manufacturer){
        super(partNo, name, description, active, createdBy, created, updatedBy, updated);
        this.topLevel =  topLevel;
        this.manufacturer = manufacturer;
    }

    public boolean isTopLevel() {
        return topLevel;
    }

    public void setTopLevel(boolean topLevel) {
        this.topLevel = topLevel;
    }

    public void setManufacturer(Manufacturer manufacturer){
        this.manufacturer = manufacturer;
    }

    public Manufacturer getManufacturer(){
        return manufacturer;
    }

}
