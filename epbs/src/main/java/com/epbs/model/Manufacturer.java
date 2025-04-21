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

}
