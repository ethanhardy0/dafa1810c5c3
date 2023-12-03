package zzz;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import javafx.scene.control.Label;
import javafx.scene.control.TextField; 
import javafx.scene.control.ComboBox;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox; 

import javafx.stage.Stage;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

    
    public static ArrayList<Student> studentArray = new ArrayList<>();
    public static ArrayList<Course> courseArray = new ArrayList<>();
    public static ArrayList<Instructor> instructorArray = new ArrayList<>();
    private static int courseNum;
    private static int courseCounter;
    
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
        
        Button stuButton = new Button("Add Student ->");
        
        grid.add(stuButton,6,18);

        grid.add(stuNameLabel, 5, 3);
        grid.add(stuYearLabel, 5, 4);
        grid.add(stuMajorLabel, 5, 5);
        grid.add(stuGPALabel, 5, 6); 
        grid.add(stuEmailLabel, 5, 7);
        
        TextField stuName = new TextField();
       
        ComboBox<String> stuYear = new ComboBox<>();
        stuYear.setItems(FXCollections.observableArrayList(
                "Freshman",
                "Sophomore",
                "Junior",
                "Senior"
        ));

       
        TextField stuMajor = new TextField();
        TextField stuGPA = new TextField();
        TextField stuEmail = new TextField();
        
        grid.add(stuYear,6,4);
        grid.add(stuName, 6, 3);
        grid.add(stuMajor,6,5);
        grid.add(stuGPA,6,6);
        grid.add(stuEmail,6,7);
        
        //
        EventHandler<ActionEvent> addStudentEvent = (ActionEvent e) -> {
            Student student = new Student( stuName.getText(),stuYear.getValue(),stuMajor.getText(),Double.parseDouble(stuGPA.getText()),stuEmail.getText());
        
            studentArray.add(student);
        
            stuName.clear();
            stuMajor.clear();
            stuGPA.clear();
            stuEmail.clear(); 

            // Prints student objects created --> DELETE WHEN FINISHED
            for(int i =0; i < studentArray.size();i++)  {
                System.out.println(studentArray.get(i).getName());
                System.out.println(studentArray.get(i).getStudentMajor());
                System.out.println(studentArray.get(i).getGPA());
                System.out.println(studentArray.get(i).getStudentYear());
                System.out.println(studentArray.get(i).getStudentEmail());
                System.out.println(studentArray.get(i).getStudentID());
            }
        }; 
 
        // when button is pressed 
        stuButton.setOnAction(addStudentEvent); 
  
        
        Label courNameLabel = new Label("Add Course:");
        Button courButton = new Button("Add Course ->");
        
        Label courseNameLabel = new Label("Course Name: ");
        Label courseBuildingLabel = new Label("Course Building Name:");
        Label roomNumberLabel = new Label("Room Number:");
        Label courseCapacityLabel = new Label("Max Capacity:");
        grid.add(courButton, 16, 18);
        
        grid.add(courNameLabel, 15, 2);
        grid.add(courseNameLabel,15,3);
        grid.add(courseBuildingLabel,15,4);
        grid.add(roomNumberLabel, 15,5);
        grid.add(courseCapacityLabel,15,6);
        
        TextField courseNameField = new TextField();
        //TextField courseBuildingField = new TextField();
        ComboBox<String> courseBuildingDrop = new ComboBox<>();
        courseBuildingDrop.setItems(FXCollections.observableArrayList(
                "Showker",
                "Chandler",
                "Burress Hall"
          
        ));
        
        TextField courseRoomNumberField = new TextField();
        TextField courseCapacityField = new TextField();
        
        grid.add(courseNameField, 16,3);
        grid.add(courseBuildingDrop, 16, 4);
        grid.add(courseRoomNumberField,16,5);
        grid.add(courseCapacityField, 16,6);
        
    EventHandler<ActionEvent>addCourseEvent = (ActionEvent e) -> {
      
        Course course = new Course(courseNameField.toString(), courseBuildingDrop.getValue(),
        courseRoomNumberField.toString(),Integer.parseInt(courseCapacityField.getText()));
      
        courseArray.add(course);
        System.out.println("Course Array length"+ courseArray.size());
        Label success = new Label("Course added!");

        if(courseArray.size()> courseCounter)   {
            courseCounter++;
            System.out.println("Course counter" + courseCounter);
            Duration duration = Duration.seconds(2);
            grid.add(success,20,20);
      
            Timeline timeline = new Timeline(new KeyFrame(duration, event -> success.setVisible(false)));
      
            timeline.setCycleCount(1);
            timeline.play();
        }
        courseNameField.clear();
        courseRoomNumberField.clear();
        courseCapacityField.clear();
    };  

    courButton.setOnAction(addCourseEvent);
         
    StackPane mainPane = new StackPane(grid);  
        
    var scene = new Scene(mainPane, 720, 480);
    stage.setScene(scene);
    stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}