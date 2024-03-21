package com.example.studentmanagement;

public class Course{

    private String name;
    private String ID;
    private double grade;


    public Course(String name, String ID, double grade){
        this.name = name;
        this.ID = ID;
        this.grade = grade;
    }

    public Course(String name, String ID){
        this.name = name;
        this.ID = ID;
        this.grade = 0;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
