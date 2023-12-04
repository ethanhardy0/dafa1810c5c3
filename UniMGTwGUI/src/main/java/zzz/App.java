package zzz;

import java.util.ArrayList;
import java.util.Collection;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
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
        GridPane grid = new GridPane();
        grid.setVgap(1);
        grid.setHgap(1);

        // Student

        Label studentLabel = new Label("Add Student:");
        grid.add(studentLabel, 5, 2);
        Button stuButton = new Button("Add Student ->");
        grid.add(stuButton,6,18);      

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
        
        TextField stuNameField = new TextField();
        ComboBox<String> stuYearDrop = new ComboBox<>();
        stuYearDrop.setItems(FXCollections.observableArrayList(
                "Freshman",
                "Sophomore",
                "Junior",
                "Senior"
        ));
        TextField stuMajorField = new TextField();
        TextField stuGPAField = new TextField();
        TextField stuEmailField = new TextField();
        
        grid.add(stuYearDrop,6,4);
        grid.add(stuNameField, 6, 3);
        grid.add(stuMajorField,6,5);
        grid.add(stuGPAField,6,6);
        grid.add(stuEmailField,6,7);
        
        //
        EventHandler<ActionEvent> addStudentEvent = (ActionEvent e) -> {

            Student student = new Student(stuNameField.getText(), stuYearDrop.getValue(), stuMajorField.getText(), 
                Double.parseDouble(stuGPAField.getText()), stuEmailField.getText());
        
            studentArray.add(student);
        
            stuNameField.clear();
            stuMajorField.clear();
            stuGPAField.clear();
            stuEmailField.clear(); 
            // NEED TO CLEAR COMBOBOXES

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
  
        // Course

        Label courseLabel = new Label("Add Course:");
        grid.add(courseLabel, 15, 2);
        Button courseButton = new Button("Add Course ->");
        grid.add(courseButton, 16, 18);

        Label courseNameLabel = new Label("Course Name: ");
        Label courseBuildingLabel = new Label("Building:");
        Label roomNumberLabel = new Label("Room Number:");
        Label courseCapacityLabel = new Label("Max Capacity:");
        
        grid.add(courseNameLabel,15,3);
        grid.add(courseBuildingLabel,15,4);
        grid.add(roomNumberLabel, 15,5);
        grid.add(courseCapacityLabel,15,6);
        
        TextField courseNameField = new TextField();
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
            courseRoomNumberField.toString(), Integer.parseInt(courseCapacityField.getText()));
      
            courseArray.add(course);

            
            System.out.println("Course Array length"+ courseArray.size());
            Label success = new Label("Course added!");

            if (courseArray.size() > courseCounter)   {
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
            // NEED TO CLEAR COMBOBOXES
        };  
        courseButton.setOnAction(addCourseEvent);

        // Instructor

        Label instrLabel = new Label("Add Instructor:");
        grid.add(instrLabel, 25, 2);
        Button instrButton = new Button("Add Instructor ->");
        grid.add(instrButton, 26, 18);

        Label instrNameLabel = new Label("Name:");
        Label instrPrefixLabel = new Label("Prefix:");
        Label instrOfficeLabel = new Label("Office:");
        Label instrDeptLabel = new Label("Department:");
        Label instrEmailLabel = new Label("Email:");
        
        grid.add(instrNameLabel, 25, 3);
        grid.add(instrPrefixLabel, 25, 4);
        grid.add(instrOfficeLabel, 25, 5);
        grid.add(instrDeptLabel, 25, 6);
        grid.add(instrEmailLabel, 25, 7);

        TextField instrNameField = new TextField();
        ComboBox<String> instrPrefixDrop = new ComboBox<>();
        instrPrefixDrop.setItems(FXCollections.observableArrayList(
            "Dr.",
                "Ms.",
                "Mrs.",
                "Mr."
        ));
        TextField instrOfficeField = new TextField();
        TextField instrDeptField = new TextField();
        TextField instrEmailField = new TextField();

        grid.add(instrNameField, 26, 3);
        grid.add(instrPrefixDrop, 26, 4);
        grid.add(instrOfficeField, 26, 5);
        grid.add(instrDeptField, 26, 6);
        grid.add(instrEmailField, 26, 7);

        EventHandler<ActionEvent>addInstrEvent = (ActionEvent e) -> {
            Instructor instructor = new Instructor(instrNameField.toString(), /* IDK */ (String) instrPrefixDrop.getValue(), 
                instrOfficeField.toString(), instrDeptField.toString(), instrEmailField.toString());

            instructorArray.add(instructor);

            instrNameField.clear();
            instrOfficeField.clear();
            instrDeptField.clear();
            instrEmailField.clear();
        };
        instrButton.setOnAction(addInstrEvent);

        StackPane mainPane = new StackPane(grid);  
        
        var scene = new Scene(mainPane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}