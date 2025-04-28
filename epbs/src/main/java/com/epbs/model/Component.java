package com.epbs.model;

import java.time.LocalDate;

public abstract class Component {
    private int partNo;
    private String name;
    private String description;
    private boolean active;

    private int createdBy;
    private LocalDate createdAt;
    private int updatedBy;
    private LocalDate updatedAt;
}
