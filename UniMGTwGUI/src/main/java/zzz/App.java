package zzz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import javafx.scene.control.Label;
import javafx.scene.control.TextField; 
import javafx.scene.control.ComboBox;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox; 

import javafx.stage.Stage;
/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
    // Different parts of GUI
        // Student
        GridPane grid = new GridPane();
        grid.setVgap(1);
        grid.setHgap(1);
        
        Label studentLabel = new Label("Add Student:");
        grid.add(studentLabel, 5, 2);
        
        // Add Student Labels
        Label stuNameLabel = new Label("Name: ");
        Label stuYearLabel = new Label("Year:");
        Label stuMajorLabel = new Label("Major:");
        Label stuGPALabel = new Label("GPA:");
        Label stuEmailLabel = new Label("Email:");

        grid.add(stuNameLabel, 5, 3);
        grid.add(stuYearLabel, 5, 4);
        grid.add(stuMajorLabel, 5, 5);
        grid.add(stuGPALabel, 5, 6); 
        grid.add(stuEmailLabel, 5, 7);
        
        TextField stuName = new TextField();
        
        grid.add(stuName, 6, 3);
        
        // Course
        Label courNameLabel = new Label("Add Course:");
        grid.add(courNameLabel, 15, 2);   
        
        var scene = new Scene(new StackPane(grid), 720, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}  