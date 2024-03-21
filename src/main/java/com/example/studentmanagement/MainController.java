package com.example.studentmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MainController {
    @FXML
    private Label errors;

    @FXML
    private TextField idfind;



    public void login(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("management-view.fxml"));
        SceneController.switchScene(root, event);
    }

    public void student(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("student-view.fxml"));
        SceneController.switchScene(root, event);
    }

    public void course(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("course-view.fxml"));
        SceneController.switchScene(root, event);
    }

    public void add(ActionEvent event) throws IOException {
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("add-view.fxml"));
        Parent root = loader.load();

        ManagementController managementController = loader.getController();
        SceneController.switchScene(root, event);
    }

    public void find(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("find-view.fxml"));
        SceneController.switchScene(root, event);
    }
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

    public void view(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("view-view.fxml"));
        SceneController.switchScene(root, event);
    }

    public void courseSelection(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("course_selection.fxml"));
        SceneController.switchScene(root, event);
    }

    public void eligibleStudentSelection(ActionEvent event, String course) throws IOException {
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("course_registration.fxml"));
        Parent root = loader.load();
        EnrollController enrollController = loader.getController();
        enrollController.setCourse(course);
        SceneController.switchScene(root, event);
    }
    public void grade(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("grade-view.fxml"));
        SceneController.switchScene(root, event);
    }





}