package com.example.studentmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Course-Selection Management System
 *
 */
public class SelectCourseController implements Initializable {

    @FXML
    private ChoiceBox<String> courses;

    private String selectedCourse;

    /**
     * Initializes the SelectCourseController.
     * Populates the ChoiceBox with available courses.
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> courseList = new ArrayList<>();
        for (var c : Administrator.getCourses()){
            courseList.add(c.getID());
        }
        courses.getItems().addAll(courseList);
        courses.setOnAction(this::pickCourse);
    }

    /**
     * Redirects to the management page when go home button is clicked.
     * @param event The ActionEvent triggering the method call.
     * @throws IOException If an I/O error occurs.
     */
    public void home(ActionEvent event) throws IOException {
        new MainController().login(event);
    }

    /**
     * Sets the selected course when picked from the ChoiceBox.
     * @param event The ActionEvent triggering the method call.
     */
    public void pickCourse(ActionEvent event){
        selectedCourse = courses.getValue();
        System.out.println(selectedCourse);
    }

    /**
     * Redirects to the page for selecting eligible students for enrollment in the
     * selected course.
     * @param event The ActionEvent triggering the method call.
     * @throws IOException If an I/O error occurs.
     */
    public void selectCourse(ActionEvent event) throws IOException{
        selectedCourse = courses.getValue();
        new MainController().eligibleStudentSelection(event, selectedCourse);
    }


}
