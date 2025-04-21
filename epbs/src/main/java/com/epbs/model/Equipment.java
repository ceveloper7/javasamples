package com.epbs.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Equipment {
    private int id;
    private String name;
    private String description = null;
    private boolean active;

    // relacion de agregacion: Equipment has a Manufacturer
    private Manufacturer manufacturer;
    private List<Assembly> assemblies;

    private int createdBy;
    private LocalDate created;
    private int updatedBy;
    private LocalDate updated;

    // picture

    public Equipment(String name, String description, boolean active, Manufacturer manufacturer, int createdBy, LocalDate created, int updatedBy, LocalDate updated){
        this.name = Objects.requireNonNull(name, "The name can not be null");
        this.description = Objects.requireNonNullElse(description, "no description");
        this.active = active;
        this.manufacturer = Objects.requireNonNull(manufacturer, "Manufacturer of equipment can not be null");

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

    public int getId() {
        return id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }
}
