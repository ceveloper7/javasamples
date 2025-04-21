package com.epbs.model;

import java.time.LocalDate;
import java.util.Objects;

public class Manufacturer {
    private int id;
    private String code;
    private String name;
    private String description;
    private boolean active;

    private int createdBy;
    private LocalDate created;
    private int updatedBy;
    private LocalDate updated;

    public Manufacturer(String code, String name, String description, boolean active, int createdBy, LocalDate created, int updatedBy, LocalDate updated){
        this.code = Objects.requireNonNull(code, "The code can not be null");
        this.name = Objects.requireNonNull(name, "The name can not be null");
        this.description = Objects.requireNonNullElse(description, "no description");

        this.active = active;

        this.createdBy = Objects.requireNonNull(createdBy, "Created by can not be null");
        this.created = Objects.requireNonNullElseGet(created, LocalDate::now);
        this.updatedBy = Objects.requireNonNull(updatedBy, "Updated by can not be null");
        this.updated = Objects.requireNonNullElseGet(updated, LocalDate::now);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
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

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }
}
