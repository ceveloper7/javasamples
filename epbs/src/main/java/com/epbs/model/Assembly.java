package com.epbs.model;

import java.time.LocalDate;
import java.util.ArrayList;
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
        parts = new ArrayList<>();
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public LocalDate getCreated() {
        return created;
    }

    @Override
    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Override
    public int getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public LocalDate getUpdated() {
        return updated;
    }

    @Override
    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }
}
