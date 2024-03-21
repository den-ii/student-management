package com.example.studentmanagement;

import java.util.ArrayList;
import java.lang.String;

public class Administrator {

    private static ArrayList<Student> Students = new ArrayList<>();


    private static Course[] courses = {
            new Course("College Algebra", "MATH 1201", 0),
            new Course("Introduction to Statistics", "MATH 1280", 0),
            new Course("Programming Fundamentals", "CS 1101", 0),
            new Course("Programming 1", "CS 1102", 0),
            new Course("Programming 2", "CS 1103", 0)
    };

    public static ArrayList<Student> getStudents() {
        return Students;
    }

    public static Course[] getCourses() {
        return courses;
    }

    public static Student checkId(int ID){
        for (Student s: Students){
            if (s.getID() == ID){
                return s;
            }
        }
        return null;
    }

    public static Course checkCourseId(String ID){
        for (Course c: courses){
            if (c.getID().equals(ID)){
                return c;
            }
        }
        return null;
    }
    public static boolean addStudent(Student s){
        if (checkId(s.getID()) == null){
            Students.add(s);
            return true;
        }
        else {
            return false;
        }
    }

    public static void enroll(Student student, Course course){
        if (student != null){
            student.getCourseList().add(course);
        }
    }
}
