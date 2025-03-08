package org.ceva.ch02.model;

/**
 * Una Section es un curso que se ofrece en un semestre determinado
 */
public class Section {
    private String semester;
    private String place;
    private String daysAndTimes;

    private StudentLinkedList studentList;

    /**
     * Asociacion (muchos a uno) entre Section --> Course (cada Section tiene un Course)
     * Referencia a una objeto Course
     */
    private Course course;

    public Section(Course course, String semestre, String place, String daysAndTimes){
        this.course = course;
        this.semester = semestre;
        this.place = place;
        this.daysAndTimes = daysAndTimes;
    }

    public String getPlace() {
        return place;
    }
    public String getDaysAndTimes() {
        return daysAndTimes;
    }
    public String getSemester() {
        return semester;
    }
    public Course getCourse() {
        return course;
    }
    public void setPlace(String newPlace) {
        place = newPlace;
    }
    public void setDaysAndTimes(String newDaysAndTimes) {
        daysAndTimes = newDaysAndTimes;
    }
}
