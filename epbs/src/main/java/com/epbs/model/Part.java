package com.epbs.model;

import java.time.LocalDate;

/**
 * Superclass Item
 */
public class Part {
    private int partNo;
    private int internalNo;
    private String name;
    private String description;
    private boolean assembly;

    private boolean isActive;
    private int createdBy;
    private LocalDate created;
    private int updatedBy;
    private LocalDate updated;

    public Part(int partNo, int internalNo, String name, String description, boolean isAnAssebly){
        this.partNo = partNo;
        this.name = name;
        this.description = description;
        this.assembly = isAnAssebly;
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
}
