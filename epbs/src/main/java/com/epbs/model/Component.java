package com.epbs.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract sealed class Component permits Part, Assembly {
    private int partNo;
    private String name;
    private String description;
    private boolean active;

    private int createdBy;
    private LocalDate createdAt;
    private int updatedBy;
    private LocalDate updatedAt;

    public Component(int partNo, String name, String description, boolean active, int createdBy, LocalDate createdAt, int updatedBy, LocalDate updatedAt){
        this.partNo = partNo;
        this.name = name;

        if(description.isBlank())
            this.description = name;
        
        this.description = description;
        this.active = active;

        if(createdBy == 0)
            System.out.println("Created by can not be 0");
        else
            this.createdBy = createdBy;

        this.createdAt = Objects.requireNonNullElseGet(createdAt, LocalDate::now);

        if(updatedBy == 0)
            System.out.println("Updated by can not be null");
        else
            this.updatedBy = updatedBy;

        this.updatedAt = Objects.requireNonNullElseGet(updatedAt, LocalDate::now);
    }

    public void setPartNo(int partNo) {
        this.partNo = partNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getPartNo() {
        return partNo;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object otherObject){
        if(this == otherObject) return true;

        if (otherObject == null) return false;

        // instanceof pattern matching, si otherObject es una instancia de Part, la variable other hace referencia a otherObject
        if(!(otherObject instanceof Component other)) return false;

        return partNo == other.partNo
                && Objects.equals(name, other.name)
                && Objects.equals(description, other.description)
                && active == other.active;
    }

    @Override
    public int hashCode(){
        return Objects.hash(partNo, name, description, active);
    }
}
