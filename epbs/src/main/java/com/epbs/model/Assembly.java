package com.epbs.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Subclass or derived class or child class Assembly
 * Relationship: An Assembly is a Part. each Assembly object is an object of the Superclass Part.
 */
public non-sealed class Assembly extends Component implements Comparable<Assembly>{
    private boolean topLevel;
    private Manufacturer manufacturer;

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

    @Override
    public boolean equals(Object otherObject){
        if(!super.equals(otherObject)) return false;

        Assembly other = (Assembly) otherObject;
        return topLevel == other.topLevel && Objects.equals(manufacturer, other.manufacturer);
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), topLevel, manufacturer);
    }

    @Override
    public String toString() {
        return "Component Assembly[" + manufacturer.getCode() + super.getPartNo() + ", " + super.getName();
    }

    @Override
    public int compareTo(Assembly other){
        return Integer.compare(super.getPartNo(), other.getPartNo());
    }
}
