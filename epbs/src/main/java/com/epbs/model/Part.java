package com.epbs.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Superclass Item
 */
public class Part {
    private int partNo;
    private int internalNo;
    private String name;
    private String description = null;
    private boolean assembly;
    private boolean active;

    private int createdBy;
    private LocalDate created;
    private int updatedBy;
    private LocalDate updated;

    public Part(int partNo, int internalNo, String name, String description, boolean assembly, boolean active, int createdBy, LocalDate created, int updatedBy, LocalDate updated){
        if(partNo == 0)
            System.out.println("PartNo can not be null");
        else
            this.partNo = partNo;

        this.name = Objects.requireNonNull(name, "Name can not be null");
        this.description = Objects.requireNonNullElse(description, "No description");
        this.assembly = assembly;
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

    public int getItemNo() {
        return partNo;
    }

    public void setItemNo(int itemNo) {
        this.partNo = itemNo;
    }

    public int getInternalNo() {
        return internalNo;
    }

    public void setInternalNo(int internalNo) {
        this.internalNo = internalNo;
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

    public boolean isAssembly() {
        return assembly;
    }

    public void setAsAssembly(boolean assembly) {
        this.assembly = assembly;
    }

    public boolean getActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
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
