package com.example.studentmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Controller class for the main functionality of the student management system.
 */
public class MainController {
    @FXML
    private Label errors;

    @FXML
    private TextField idfind;


    /**
     * Logs in, Handles the action when the login button is clicked.
     *
     * @param event The ActionEvent triggered by clicking the button.
     * @throws IOException If an I/O error occurs.
     */
    public void login(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("management-view.fxml"));
        SceneController.switchScene(root, event);
    }

    /**
     * Handles the action when the student button is clicked,
     * navigates to the student management system.
     *
     * @param event The ActionEvent triggered by clicking the button.
     * @throws IOException If an I/O error occurs.
     */
    public void student(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("student-view.fxml"));
        SceneController.switchScene(root, event);
    }

    /**
     * Handles the action when the student button is clicked,
     * navigates to the course management system.
     *
     * @param event The ActionEvent triggered by clicking the button.
     * @throws IOException If an I/O error occurs.
     */
    public void course(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("course-view.fxml"));
        SceneController.switchScene(root, event);
    }

    /**
     * Handles the action when the add button is clicked on student scene,
     * navigates to the add student management system.
     *
     * @param event The ActionEvent triggered by clicking the button.
     * @throws IOException If an I/O error occurs.
     */

    public void add(ActionEvent event) throws IOException {
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("add-view.fxml"));
        Parent root = loader.load();

        ManagementController managementController = loader.getController();
        SceneController.switchScene(root, event);
    }

    /**
     * Generates a scene to get student's id
     *
     * @param event The ActionEvent triggered by clicking the button.
     * @throws IOException If an I/O error occurs.
     */

    public void find(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("find-view.fxml"));
        SceneController.switchScene(root, event);
    }

    /**
     * Handles the action when the update button is clicked on student scene,
     * navigates to the update student management system.
     *
     * @param event The ActionEvent triggered by clicking the button.
     * @throws IOException If an I/O error occurs.
     */
    public void update(ActionEvent event) throws IOException {
        try{
            int rID = Integer.parseInt(idfind.getText());
            Student s = Administrator.checkId(rID);
            if (s != null){
                FXMLLoader loader =  new FXMLLoader(getClass().getResource("update-view.fxml"));
                Parent root = loader.load();
                ManagementController managementController = loader.getController();
                managementController.showForUpdate(s);
                SceneController.switchScene(root, event);

            } else errors.setText("Student's id has not been registered");
        } catch (Exception e){
            errors.setText("Student's id must be a number");
        }
    }

    /**
     * Handles the action when the view button is clicked on student scene,
     * navigates to the view student management system.
     *
     * @param event The ActionEvent triggered by clicking the button.
     * @throws IOException If an I/O error occurs.
     */
    public void view(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("view-view.fxml"));
        SceneController.switchScene(root, event);
    }

    /**
     * Handles the action when the select button is clicked on course scene,
     * navigates to the course-selection management system.
     *
     * @param event The ActionEvent triggered by clicking the button.
     * @throws IOException If an I/O error occurs.
     */
    public void courseSelection(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("course_selection.fxml"));
        SceneController.switchScene(root, event);
    }

    /**
     * Handles the action when a couse is selected on the course-selection scene,
     * navigates to the student-selection management system to select eligible students.
     *
     * @param event The ActionEvent triggered by clicking the button.
     * @throws IOException If an I/O error occurs.
     */
    public void eligibleStudentSelection(ActionEvent event, String course) throws IOException {
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("course_registration.fxml"));
        Parent root = loader.load();
        EnrollController enrollController = loader.getController();
        enrollController.setCourse(course);
        SceneController.switchScene(root, event);
    }

    /**
     * Handles the action when the grade button is clicked, navigates to the grade management system.
     *
     * @param event The ActionEvent triggered by clicking the button.
     * @throws IOException If an I/O error occurs.
     */
    public void grade(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("grade-view.fxml"));
        SceneController.switchScene(root, event);
    }



}