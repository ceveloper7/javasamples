package com.epbs.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Superclass Item
 */
public class Part {
//    private int id;
    private int partNo;
    private String name;
    private String description;

    private boolean active;
    private int createdBy;
    private LocalDate created;
    private int updatedBy;
    private LocalDate updated;

    public Part(){
        this(0,  "", "",  false, 0, LocalDate.now(), 0, LocalDate.now());
    }

    public Part(int partNo, String name, String description, boolean active, int createdBy, LocalDate created, int updatedBy, LocalDate updated){
        this.partNo = partNo;
        this.name = Objects.requireNonNull(name, "Name can not be null");
        this.description = Objects.requireNonNullElse(description, "No description");

        this.active = active;

        if(createdBy == 0)
            System.out.println("Created by can not be 0");
        else
            this.createdBy = createdBy;

        this.created = Objects.requireNonNullElseGet(created, LocalDate::now);

        if(updatedBy == 0)
            System.out.println("Updated by can not be null");
        else
            this.updatedBy = updatedBy;

        this.updated = Objects.requireNonNullElseGet(updated, LocalDate::now);
    }

    public int getPartNo() {
        return partNo;
    }

    public void setPartNo(int partNo) {
        this.partNo = partNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getActive(){
        return active;
    }

    public void setTopLevel(boolean topLevel){
        this.active = topLevel;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }
}
