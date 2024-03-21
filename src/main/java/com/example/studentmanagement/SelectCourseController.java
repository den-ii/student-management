package com.example.studentmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SelectCourseController implements Initializable {

    @FXML
    private ChoiceBox<String> courses;

    private String selectedCourse;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> courseList = new ArrayList<>();
        for (var c : Administrator.getCourses()){
            courseList.add(c.getID());
        }
        courses.getItems().addAll(courseList);
        courses.setOnAction(this::pickCourse);
    }

    public void home(ActionEvent event) throws IOException {
        new MainController().login(event);
    }

    public void pickCourse(ActionEvent event){
        selectedCourse = courses.getValue();
        System.out.println(selectedCourse);
    }
    public void selectCourse(ActionEvent event) throws IOException{
        selectedCourse = courses.getValue();
        new MainController().eligibleStudentSelection(event, selectedCourse);
    }


}
