package com.example.studentmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * View Students
 */
public class ViewController implements Initializable {
    @FXML
    private ListView<String> studentsList;

    @FXML
    private Label numberOfStudents;



    /**
     * Initializes the view with the list of students.
     * @param url The location used to resolve relative paths for the root object,
     *            or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object,
     *                       or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> students = new ArrayList<>() ;
        for (Student s: Administrator.getStudents()){
            students.add(String.format("Name: %s, ID: %d, Age: %d, ", s.getName(), s.getID(), s.getAge()));
        }
        int size = students.size();
        numberOfStudents.setText(String.valueOf("Number Of Students: "+ size));
        if (size > 0){
            studentsList.getItems().addAll(students);
        }
    }

    /**
     * Handles the event when the go home button is clicked, navigates to home.
     * @param event The action event triggered by clicking the home button.
     * @throws IOException If an I/O error occurs.
     */
    public void home(ActionEvent event) throws IOException {
        new MainController().login(event);
    }
}
