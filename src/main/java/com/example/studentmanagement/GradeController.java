package com.example.studentmanagement;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.lang.String;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GradeController implements Initializable {
    @FXML
    private ListView<String> list;

    @FXML
    private Label heading;

    @FXML
    private TextField grade;

    private Course c;

    private Student stud;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> students = new ArrayList<>() ;
        for (Student s: Administrator.getStudents()){
            students.add(String.format("Name: %s, ID: %d, Age: %d", s.getName(), s.getID(), s.getAge()));
        }
        int size = students.size();
        if (size > 0){
            list.getItems().addAll(students);
        }
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (heading.getText().equals("Grade Update")){
                    int ID = Integer.parseInt(list.getSelectionModel().getSelectedItem().split("ID: ")[0].split(",")[0]);
                    stud = Administrator.checkId(ID);
                    ArrayList<String> studcourse = new ArrayList<>() ;
                    for (Course c: stud.getCourseList()){
                        studcourse.add(String.format("Code: %s, Name: %s, : %d, Current Grade: %.2f", c.getName(), c.getID(), c.getGrade()));
                    }
                    heading.setText("Update Grade");
                    list.getItems().addAll();
                }
                else{
                    String ID = list.getSelectionModel().getSelectedItem().split("Code: ")[0].split(",")[0];
                    c = Administrator.checkCourseId(ID);
                     if (stud != null && c != null){
                       for (Course cSet: stud.getCourseList()){
                           if (cSet.getID().equals(c.getID())){
                               grade.setText(Double.toString(c.getGrade()));
                           }
                       }

                     }
                }

            }
        });
    }

    public void updateGrade(){
        if (stud != null && c != null){
            for (Course cSet: stud.getCourseList()){
                if (cSet.getID().equals(c.getID())){
                    cSet.setGrade(Double.parseDouble(grade.getText()));
                    grade.setText(Double.toString(c.getGrade()));
                }
            }

        }
    }

    public void home(ActionEvent event) throws IOException {
        new MainController().login(event);
    }
}
