package com.epbs.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Superclass Item
 */
public non-sealed class  Part extends Component {

    private boolean kit;

    public Part(){
        this(0,  "", "", false, false, 0, LocalDate.now(), 0, LocalDate.now());
    }

    public Part(int partNo, String name, String description, boolean kit, boolean active, int createdBy, LocalDate createdAt, int updatedBy, LocalDate updatedAt){
        super(partNo, name, description, active, createdBy, createdAt, updatedBy, updatedAt);
        this.kit = kit;
    }

    public boolean isAKit(){
        return kit;
    }

    public void setKit(boolean kit){
        this.kit = kit;
    }

    @Override
    public boolean equals(Object otherObject){
        if(!super.equals(otherObject)) return false;
        Part other = (Part) otherObject;
        return kit == other.kit;
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), kit);
    }

    @Override
    public String toString(){
        return "Component Part[" + super.getPartNo() + ", " + super.getName() +  "]";
    }

}
