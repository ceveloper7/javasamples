package com.epbs.model;

import java.time.LocalDate;
import java.util.Objects;

public class Manufacturer {
    private int id;
    private String code;
    private String name;
    private String description;
    private char active;

    private int createdBy;
    private LocalDate created;
    private int updatedBy;
    private LocalDate updated;

    public Manufacturer(){
    }

    public Manufacturer(String name, String code, String description, char active, int createdBy, LocalDate created, int updatedBy, LocalDate updated){
        this.code = Objects.requireNonNull(code, "The code can not be null");
        this.name = Objects.requireNonNull(name, "The name can not be null");
        this.description = Objects.requireNonNullElse(description, "no description");

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

    public char isActive() {
        return active;
    }

    public void setActive(char active) {
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

    @Override
    public boolean equals(Object otherObject){
        if(this == otherObject) return true;

        if (otherObject == null) return false;

        if(!(otherObject instanceof Manufacturer other)) return false;

        return id == other.id
                && Objects.equals(code, other.code)
                && Objects.equals(name, other.name)
                && Objects.equals(description, other.description)
                && active == other.active;
    }

    @Override
    public int hashCode(){
       return Objects.hash(id, code, name, description, active);
    }

    @Override
    public String toString(){
        return "Manufacturer[" + code + ", " + name + "]";
    }
}
