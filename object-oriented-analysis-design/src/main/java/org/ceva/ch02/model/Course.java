package org.ceva.ch02.model;

public class Course {
    private String id;
    private String name;
    private int numberOfCredits;
    private String description;

    public Course(String id, String name){
        this.id = id;
        this.name = name;
    }

    public void setNumberOfCredits(int credits){
        this.numberOfCredits = credits;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getNumberOfCredits(){
        return numberOfCredits;
    }

    /**
     * Creamos un objeto Section
     */
    public Section createSection(String semester, String place, String time){
        return new Section(this, semester, place, time);
    }
}
