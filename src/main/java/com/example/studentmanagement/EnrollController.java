package com.example.studentmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.lang.String;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller class for handling student enrollment in courses.
 */
public class EnrollController implements Initializable {
    @FXML
    private ChoiceBox<String> students;

    @FXML
    private Label errors;
    private int selectedStudent;

    private Course course;


    /**
     * Initializes the ChoiceBox controller with a list of eligible students.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> studentList = new ArrayList<>();
        for (Student s : Administrator.getStudents()){
            if (s.getCourseList().size() < 2 && !checkEnrolledCourse(s, course)){
                studentList.add(s.getID()+" - "+s.getName());
            }
        }
        students.getItems().addAll(studentList);
        students.setOnAction(this::pickStudent);
    }

    /**
     * Checks if a student is already enrolled in a course.
     *
     * @param student The student to check.
     * @param course  The course to check enrollment for.
     * @return True if the student is enrolled in the course, false otherwise.
     */
    public boolean checkEnrolledCourse(Student student, Course course){
        for (Course c: student.getCourseList()){
            if (c.getID().equals(course.getID())){
                return true;
            }
        }
        return false;
    }

    /**
     * Handles the action when the "Home" button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the button.
     * @throws IOException If an I/O error occurs.
     */
    public void home(ActionEvent event) throws IOException {
        new MainController().login(event);
    }


    /**
     * Picks the selected student from the choice box.
     *
     * @param event The ActionEvent triggered by selecting a student.
     */
    public void pickStudent(ActionEvent event){
        selectedStudent = Integer.parseInt(students.getValue().split(" ")[0]);
        System.out.println(selectedStudent);
    }

    /**
     * Sets the course for enrollment.
     *
     * @param courseID The ID of the course to enroll the student in.
     */
    public void setCourse(String courseID){
        course = Administrator.checkCourseId(courseID);
        System.out.println(course);
    }

    /**
     * Enrolls the selected student in the course.
     */
    public void enroll(){
        Administrator.enroll(Administrator.checkId(selectedStudent), course);
        errors.setText("Successfully enrolled");
    }

}
