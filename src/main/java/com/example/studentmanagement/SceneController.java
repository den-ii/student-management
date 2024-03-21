package com.example.studentmanagement;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

     static Stage stage;
    private static Scene scene;
    private static Parent root;

    public static void switchScene(Parent roots, ActionEvent event) throws IOException {
        root = roots;
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1300, 650);
        stage.setScene(scene);
        stage.show();
    }
}
