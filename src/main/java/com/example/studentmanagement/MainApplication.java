package com.example.studentmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        Font.loadFont("Poppins/Poppins-Black.ttf", 16);
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Student Management System");
        Image icon = new Image("uopeople.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}