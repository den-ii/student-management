package com.example.studentmanagement;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GradeController implements Initializable {
    @FXML
    private ListView<String> list;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> students = new ArrayList<>() ;
        for (var s: Administrator.getStudents()){
            students.add(String.format("Name: %s, ID: %d, Age: %d, Current Grade: %.2f", s.name(), s.ID(), s.age(), s.grade()));
        }
        int size = students.size();
        if (size > 0){
            list.getItems().addAll(students);
        }
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends java.lang.String> observableValue, java.lang.String s, java.lang.String t1) {
                int ID = Integer.parseInt(list.getSelectionModel().getSelectedItem().split("ID: ").split(",")[0]);
                Student stud = Administrator.checkId(ID);
                ArrayList<String> studcourse = new ArrayList<>() ;
                for (var c: stud.courseList()){
                    studcourse.add(String.format("Code: %s, Name: %s, : %d, Current Grade: %.2f", s.name(), s.ID(), s.age(), s.grade()));
                }

                list.getItems().addAll();
            }
        });
    }

    public void updateGrade()

    public void home(ActionEvent event) throws IOException {
        new MainController().login(event);
    }
}
