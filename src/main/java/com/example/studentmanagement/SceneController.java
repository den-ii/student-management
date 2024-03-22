package com.example.studentmanagement;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Handle scene switching
 *
 */
public class SceneController {

     static Stage stage;
    private static Scene scene;
    private static Parent root;

    /**
     *  Helps in navigating to the necessary scenes needed
     * @param roots
     * @param event
     * @throws IOException
     */
    public static void switchScene(Parent roots, ActionEvent event) throws IOException {
        root = roots;
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1300, 650);
        stage.setScene(scene);
        stage.show();
    }
}
