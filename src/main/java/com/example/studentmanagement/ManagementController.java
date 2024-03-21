package com.example.studentmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.lang.String;

import java.io.IOException;

public class ManagementController {
    @FXML
    private TextField name;
    @FXML
    private TextField ID ;
    @FXML
    private TextField age;

    @FXML
    private Button btn;

    @FXML
    private Label errors;

    @FXML
    private ChoiceBox courses;


    public void register(){
        int rage;
        int rid;
        if (name.getText().isBlank()){
            errors.setText("Name must have a value!!");
            return;
        }
        try{
            rid = Integer.parseInt(ID.getText());
            rage = Integer.parseInt(age.getText());
            if (rage <= 10){
                errors.setText("Student must be above 10");
            }
            else {
                Student s = new Student(name.getText(), rid, rage);
                System.out.println(s);
                boolean added = Administrator.addStudent(s);
                String cmd = btn.getText().equals("Register")? " added": " updated";
                if (added) errors.setText(name.getText() + cmd + " successfully");
                else errors.setText("Student with ID exists");
            }
        } catch (Exception e){
            errors.setText("ID and Age must be a number!!");
        }

    }
    public void update(){
        int rage;
        int rid;
        if (name.getText().isBlank()){
            errors.setText("Name must have a value!!");
            return;
        }
        try{
            rid = Integer.parseInt(ID.getText());
            rage = Integer.parseInt(age.getText());
            if (rage <= 10){
                errors.setText("Student must be above 10");
            }
            else {

                Student s = Administrator.checkId(rid);
                System.out.println(s);
                s.setAge(rage);
                s.setID(rid);
                s.setName(name.getText());
                errors.setText(name.getText() + " updated" + " successfully");
                System.out.println(s);
            }
        } catch (Exception e){
            errors.setText("ID and Age must be a number!!");
        }

    }


    public void home(ActionEvent event) throws IOException {
         new MainController().login(event);
    }

    public void showForUpdate(Student s){
        name.setText(s.getName());
        ID.setText(String.valueOf(s.getID()));
        age.setText(String.valueOf(s.getAge()));
    }




}
