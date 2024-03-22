package com.example.studentmanagement;
import java.lang.String;
import java.util.ArrayList;

/**
 * Represents a course in the student management system.
 * Student POJO
 *
 */
public class Student {

    private String name;
    private int ID;
    private int age;

    private ArrayList<Course> courseList;

    /**
     * Constructs a Student object with the specified name, ID, and age.
     * Initializes an empty list of courses for the student.
     * @param name The name of the student.
     * @param ID The ID of the student.
     * @param age The age of the student.
     */
    public Student(String name, int ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
        this.courseList = new ArrayList<>();
    }

    /**
     * Retrieves the name of the student.
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the list of courses associated with the student.
     * @return The list of courses associated with the student.
     */
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    /**
     * Sets the list of courses associated with the student.
     * @param courseList The list of courses to set.
     */
    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    /**
     * Retrieves the ID of the student.
     * @return The ID of the student.
     */
    public int getID() {
        return ID;
    }

    /**
     * Retrieves the age of the student.
     * @return The age of the student.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the name of the student.
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the ID of the student.
     * @param ID The ID to set.
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Sets the age of the student.
     * @param age The age to set.
     */
    public void setAge(int age) {
        this.age = age;
    }
}
