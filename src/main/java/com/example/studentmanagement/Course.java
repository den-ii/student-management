package com.example.studentmanagement;

/**
 * Represents a course in the student management system.
 */
public class Course {

    private String name;
    private String ID;
    private double grade;

    /**
     * Constructs a course with the specified name, ID, and grade.
     *
     * @param name  The name of the course.
     * @param ID    The ID of the course.
     * @param grade The grade of the course.
     */
    public Course(String name, String ID, double grade) {
        this.name = name;
        this.ID = ID;
        this.grade = grade;
    }

    /**
     * Constructs a course with the specified name and ID. The grade is initialized to 0.
     *
     * @param name The name of the course.
     * @param ID   The ID of the course.
     */
    public Course(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.grade = 0;
    }

    /**
     * Retrieves the name of the course.
     *
     * @return The name of the course.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the ID of the course.
     *
     * @return The ID of the course.
     */
    public String getID() {
        return ID;
    }

    /**
     * Retrieves the grade of the course.
     *
     * @return The grade of the course.
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Sets the name of the course.
     *
     * @param name The name of the course to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the ID of the course.
     *
     * @param ID The ID of the course to set.
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Sets the grade of the course.
     *
     * @param grade The grade of the course to set.
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }
}
