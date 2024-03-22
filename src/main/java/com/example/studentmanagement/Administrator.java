package com.example.studentmanagement;

import java.util.ArrayList;
import java.lang.String;

/**
 * This class represents the administrator of the student management system.
 */
public class Administrator {

    private static ArrayList<Student> Students = new ArrayList<>();


    private static Course[] courses = {
            new Course("College Algebra", "MATH 1201", 0),
            new Course("Introduction to Statistics", "MATH 1280", 0),
            new Course("Programming Fundamentals", "CS 1101", 0),
            new Course("Programming 1", "CS 1102", 0),
            new Course("Programming 2", "CS 1103", 0)
    };

    /**
     * Retrieves the list of students.
     *
     * @return The list of students.
     */
    public static ArrayList<Student> getStudents() {
        return Students;
    }

    /**
     * Retrieves the array of courses.
     *
     * @return The array of courses.
     */
    public static Course[] getCourses() {
        return courses;
    }

    /**
     * Checks if a student with the given ID exists in the system.
     *
     * @param ID The ID of the student to check.
     * @return The student object if found, otherwise null.
     */
    public static Student checkId(int ID){
        for (Student s: Students){
            if (s.getID() == ID){
                return s;
            }
        }
        return null;
    }

    /**
     * Checks if a course with the given ID exists in the system.
     *
     * @param ID The ID of the course to check.
     * @return The course object if found, otherwise null.
     */
    public static Course checkCourseId(String ID){
        for (Course c: courses){
            if (c.getID().equals(ID)){
                return c;
            }
        }
        return null;
    }

    /**
     * Adds a new student to the system.
     *
     * @param s The student object to add.
     * @return True if the student was added successfully, false if the student ID already exists.
     */
    public static boolean addStudent(Student s){
        if (checkId(s.getID()) == null){
            Students.add(s);
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Enrolls a student in a course.
     *
     * @param student The student to enroll.
     * @param course  The course to enroll the student in.
     */
    public static void enroll(Student student, Course course){
        if (student != null){
            student.getCourseList().add(course);
        }
    }
}
