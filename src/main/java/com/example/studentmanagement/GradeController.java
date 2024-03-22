package com.example.studentmanagement;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller class for managing grades.
 */
public class GradeController implements Initializable {
    @FXML
    private ListView<String> list;

    @FXML
    private Label heading;

    @FXML
    private TextField grade;

    private Course c;

    private Student stud;


    /**
     * Initializes the controller after its root element has been completely processed.
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> students = new ArrayList<>() ;
        for (Student s: Administrator.getStudents()){
            students.add(String.format("ID: %d, Name: %s, Age: %d", s.getID(), s.getName(), s.getAge()));
        }
        int size = students.size();
        if (size > 0){
            list.getItems().addAll(students);
        }
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println("clicked");
                if (heading.getText().equals("Grade Update")){
                    System.out.println(list.getSelectionModel().getSelectedItem().split("ID: ")[1].split(",")[0]);
                    int ID = Integer.parseInt(list.getSelectionModel().getSelectedItem().split("ID: ")[1].split(",")[0]);
                    stud = Administrator.checkId(ID);
                    System.out.println(stud.toString());
                    ArrayList<String> studcourse = new ArrayList<>() ;
                    for (Course c: stud.getCourseList()){
                        studcourse.add(String.format("Code: %s, Name: %s, Current Grade: %.2f",  c.getID(), c.getName(), c.getGrade()));
                    }
                    heading.setText("Update Grade");
                    System.out.println(studcourse);
                    list.getItems().addAll(studcourse);
                }
                else{
                    System.out.println("here");
                    String ID = list.getSelectionModel().getSelectedItem().split("Code: ")[1].split(",")[0];
                    System.out.println(ID);

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

    /**
     * Updates the grade of the selected student's course.
     * @param event The action event.
     * @throws IOException If an I/O exception occurs.
     */
    public void updateGrade(ActionEvent event) throws IOException {
        if (stud != null && c != null){
            for (Course cSet: stud.getCourseList()){
                if (cSet.getID().equals(c.getID())){
                    cSet.setGrade(Double.parseDouble(grade.getText()));
                    grade.setText(Double.toString(c.getGrade()));
                    new MainController().login(event);
                }
            }

        }
    }

    /**
     * Returns to the home screen.
     * @param event The action event.
     * @throws IOException If an I/O exception occurs.
     */
    public void home(ActionEvent event) throws IOException {
        new MainController().login(event);
    }
}
