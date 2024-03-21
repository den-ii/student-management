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

public class EnrollController implements Initializable {
    @FXML
    private ChoiceBox<String> students;

    @FXML
    private Label errors;
    private int selectedStudent;

    private Course course;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> studentList = new ArrayList<>();
        for (Student s : Administrator.getStudents()){
            if (s.courseList().size() < 2 && !checkEnrolledCourse(s, course)){
                studentList.add(s.ID()+" - "+s.name());
            }
        }
        students.getItems().addAll(studentList);
        students.setOnAction(this::pickStudent);
    }

    public boolean checkEnrolledCourse(Student student, Course course){
        for (Course c: student.courseList()){
            if (c.ID().equals(course.ID())){
                return true;
            }
        }
        return false;
    }

    public void home(ActionEvent event) throws IOException {
        new MainController().login(event);
    }

    public void pickStudent(ActionEvent event){
        selectedStudent = Integer.parseInt(students.getValue().split(" ")[0]);
        System.out.println(selectedStudent);
    }

    public void setCourse(String courseID){
        course = Administrator.checkCourseId(courseID);
        System.out.println(course);
    }
    public void enroll(){
        Administrator.enroll(Administrator.checkId(selectedStudent), course);
        errors.setText("Successfully enrolled");
    }

}
