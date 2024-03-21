package com.example.studentmanagement;
import java.util.ArrayList;
import java.lang.String;
public class Student {

    private String name;
    private int ID;
    private int age;

    private ArrayList<Course> courseList;


    public Student(String name, int ID, int age){
        this.name = name;
        this.ID = ID;
        this.age = age;
        this.courseList = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public int getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
