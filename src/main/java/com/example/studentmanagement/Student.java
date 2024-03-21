package com.example.studentmanagement;
import java.util.ArrayList;

public record Student(String name, int ID, int age, double grade, ArrayList<Course> courseList){

    public Student(String name, int ID, int age, double grade){
        this(name, ID, age, grade, new ArrayList<>());
    }
}
