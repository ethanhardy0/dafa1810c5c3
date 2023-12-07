package zzz;

import javafx.scene.control.CheckBox;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.stage.Stage;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
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

        TextArea updateCourseArea = new TextArea();
        updateCourseArea.setPrefRowCount(10);
        updateCourseArea.setPrefColumnCount(16);
        grid.add(updateCourseArea, 8, 29, 16, 10);

        Label studentLabel = new Label("Add Student:");
        grid.add(studentLabel, 5, 2);

        // Add Student Labels
        Label stuNameLabel = new Label("Name: ");
        Label stuYearLabel = new Label("Year:");
        Label stuMajorLabel = new Label("Major:");
        Label stuGPALabel = new Label("GPA:");
        Label stuEmailLabel = new Label("Email:");

        Button stuButton = new Button("Add Student ->");

        grid.add(stuButton, 6, 8);

        grid.add(stuNameLabel, 5, 3);
        grid.add(stuYearLabel, 5, 4);
        grid.add(stuMajorLabel, 5, 5);
        grid.add(stuGPALabel, 5, 6);
        grid.add(stuEmailLabel, 5, 7);

        TextField stuName = new TextField();
        // TextField stuYear = new TextField();

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

        grid.add(stuYear, 6, 4);
        grid.add(stuName, 6, 3);
        grid.add(stuMajor, 6, 5);
        grid.add(stuGPA, 6, 6);
        grid.add(stuEmail, 6, 7);

        ObservableList<String> stuNameList = FXCollections.observableArrayList();

        EventHandler<ActionEvent> addStudentEvent = (var e) -> {
            if (stuEmail.getText().contains("@")) {

                Student student = new Student(stuName.getText(), stuYear.getValue(), stuMajor.getText(), Double.parseDouble(stuGPA.getText()), stuEmail.getText());

                studentArray.add(student);

                stuNameList.add(student.getName());

                stuName.clear();

                stuMajor.clear();
                stuGPA.clear();
                stuEmail.clear();
            } else {
                Label missingSymbol = new Label("Not valid email! Re-enter!");
                Duration duration = Duration.seconds(5);
                grid.add(missingSymbol, 6, 9);

                Timeline timeline = new Timeline(new KeyFrame(duration, event -> missingSymbol.setVisible(false)));

                timeline.setCycleCount(1);
                timeline.play();
            }
            stuYear.getSelectionModel().clearSelection();
            
            
        };

        // when button is pressed 
        stuButton.setOnAction(addStudentEvent);

        Label courNameLabel = new Label("Add Course:");
        Button courButton = new Button("Add Course ->");

        Label courseNameLabel = new Label("Course Name: ");
        Label courseBuildingLabel = new Label("Course Building Name:");
        Label roomNumberLabel = new Label("Room Number:");
        Label courseCapacityLabel = new Label("Max Capacity:");
        grid.add(courButton, 16, 7);

        grid.add(courNameLabel, 15, 2);
        grid.add(courseNameLabel, 15, 3);
        grid.add(courseBuildingLabel, 15, 4);
        grid.add(roomNumberLabel, 15, 5);
        grid.add(courseCapacityLabel, 15, 6);

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

        grid.add(courseNameField, 16, 3);
        grid.add(courseBuildingDrop, 16, 4);
        grid.add(courseRoomNumberField, 16, 5);
        grid.add(courseCapacityField, 16, 6);

        ObservableList<String> courseNameList = FXCollections.observableArrayList();

        EventHandler<ActionEvent> addCourseEvent = (ActionEvent e) -> {

            Course course = new Course(courseNameField.getText(), courseBuildingDrop.getValue(),
                    courseRoomNumberField.getText(), Integer.parseInt(courseCapacityField.getText()));

            courseArray.add(course);

            courseNameList.add(course.getName());

            System.out.println("Course Array length" + courseArray.size());

            if (courseArray.size() > courseCounter) {
                courseCounter++;
                System.out.println("Course counter" + courseCounter);

            }

            courseNameField.clear();
            courseRoomNumberField.clear();
            courseCapacityField.clear();
            courseBuildingDrop.getSelectionModel().clearSelection();
        };

        courButton.setOnAction(addCourseEvent);
        Label addInstructorLabel = new Label("Add Instructor:");
        Label instNameLabel = new Label("Name:");
        Label instPrefixLabel = new Label("Prefix:");
        Label instOfficeLabel = new Label("Office: ");
        Label instDepartLabel = new Label("Department");
        Label instEmailLabel = new Label("Email:");

        TextField instNameText = new TextField();
        TextField instOfficeText = new TextField();
        TextField instDepartText = new TextField();
        TextField instEmailText = new TextField();

        ComboBox<String> instPrefixDrop = new ComboBox<>();
        instPrefixDrop.setItems(FXCollections.observableArrayList(
                "Dr.",
                "Ms.",
                "Mrs.",
                "Mr."
        ));

        Button addInstButton = new Button("Add Instructor->");

        grid.add(addInstructorLabel, 22, 2);
        grid.add(instNameLabel, 22, 3);
        grid.add(instPrefixLabel, 22, 4);
        grid.add(instOfficeLabel, 22, 5);
        grid.add(instDepartLabel, 22, 6);
        grid.add(instEmailLabel, 22, 7);

        grid.add(instNameText, 23, 3);
        grid.add(instPrefixDrop, 23, 4);
        grid.add(instOfficeText, 23, 5);
        grid.add(instDepartText, 23, 6);
        grid.add(instEmailText, 23, 7);

        grid.add(addInstButton, 23, 8);

        ObservableList<String> instructorNameList = FXCollections.observableArrayList();

        EventHandler<ActionEvent> addInstEvent = (ActionEvent e) -> {
            Instructor instructor = new Instructor(instNameText.getText(), instPrefixDrop.getValue(),
                    instOfficeText.getText(), instDepartText.getText(), instEmailText.getText());

            instructorArray.add(instructor);
            instructorNameList.add(instructor.getName());

            instNameText.clear();
            instOfficeText.clear();
            instDepartText.clear();
            instEmailText.clear();
            instPrefixDrop.getSelectionModel().clearSelection();

        };
        addInstButton.setOnAction(addInstEvent);

        Label buildCourseLabel = new Label("Build a Course");
        Label buildAddStudentL = new Label("Add Student:");
        Label buildToCourseL = new Label("To Course: ");
        Label buildInstructoIsL = new Label("Instructor is: ");
        Label newInstL = new Label("New Instructor?");

        grid.add(buildCourseLabel, 5, 29);
        grid.add(buildAddStudentL, 5, 32);
        grid.add(buildToCourseL, 5, 33);
        grid.add(buildInstructoIsL, 5, 35);

        RadioButton addStudentRadio = new RadioButton("Add Student");
        RadioButton removeStudentRadio = new RadioButton("Remove Student");
        CheckBox newInstBox = new CheckBox();

        ComboBox<String> nameDrop = new ComboBox<>();
        nameDrop.setItems(stuNameList);

        ComboBox<String> courseDrop = new ComboBox<>();
        courseDrop.setItems(courseNameList);

        ComboBox<String> instDrop = new ComboBox<>();
        instDrop.setItems(instructorNameList);

        Button updateCourseButton = new Button("Update Course->");

        grid.add(nameDrop, 6, 32);
        grid.add(courseDrop, 6, 33);
        grid.add(newInstBox, 6, 34);
        grid.add(newInstL, 5, 34);
        grid.add(instDrop, 6, 35);
        grid.add(updateCourseButton, 6, 36);
        grid.add(addStudentRadio, 5, 31);
        grid.add(removeStudentRadio, 6, 31);

        EventHandler<ActionEvent> buildACourseAction = (ActionEvent e) -> {
            updateCourseArea.clear();

            
            
            
            updateCourseButton.setText("Save Changes");
            buildCourseLabel.setText("Edit a course");

            for (int i = 0; i < studentArray.size(); i++) {

                if (studentArray.get(i).getName().equalsIgnoreCase(nameDrop.getValue())) {

                    for (int j = 0; j < courseArray.size(); j++) {

                        // Check if the student is not already in the course
                        if (courseArray.get(j).getName().equalsIgnoreCase(courseDrop.getValue())
                                && !courseArray.get(j).getRoster().contains(studentArray.get(i).getName())) {
                            courseArray.get(j).enrolledStudent(studentArray.get(i));
                        }

                        //updateCourseArea.clear();
                        //updateCourseArea.setText(courseArray.get(j).getRoster());
                    }

                }
            }
            for (Course course : courseArray) {
                updateCourseArea.setText("Course: " + course.getName() + " Location: " + course.getLocation() + 
                "Room: " + course.getRoom() + " Capacity: " + course.getCapacity() + " Instructor of Record: " + course.getInstructor() + "\n\n");
                updateCourseArea.appendText(course.getRoster() + "\n");
            }
            nameDrop.getSelectionModel().clearSelection();
            courseDrop.getSelectionModel().clearSelection();
            instDrop.getSelectionModel().clearSelection();
            // addStudentRadio.selectToggle(null);
        };

        newInstBox.setOnAction(event -> {
            // Set the ComboBox's disable property based on the CheckBox state
            instDrop.setDisable(!newInstBox.isSelected());
        });

        updateCourseButton.setOnAction(buildACourseAction);

        EventHandler<ActionEvent> removeStudentAction = (ActionEvent e) -> {

            String selectedCourseName = courseDrop.getValue();
            int selectedStudentID = 0;

            for (int i = 0; i < studentArray.size(); i++) {
                if (studentArray.get(i).getName().equalsIgnoreCase(nameDrop.getValue())) {

                    selectedStudentID = studentArray.get(i).getStudentID();
                }

            }

            //}
            for (Course course : courseArray) {
                if (course.getName().equalsIgnoreCase(selectedCourseName)) {
                    // Remove the student from the course based on ID
                    course.removeStudent(selectedStudentID);

                    // Update the course area
                    updateCourseArea.setText(String.join("\n", course.getRoster()));

                    // Clear selections
                    nameDrop.getSelectionModel().clearSelection();
                    courseDrop.getSelectionModel().clearSelection();
                    instDrop.getSelectionModel().clearSelection();

                    // Break out of the loop since we found and removed the student
                    return;
                }
            }

//            nameDrop.getSelectionModel().clearSelection();
//            courseDrop.getSelectionModel().clearSelection();
//            instDrop.getSelectionModel().clearSelection();
        };

        EventHandler<ActionEvent> addStudentAction = (ActionEvent e) -> {

            if (addStudentRadio.isSelected()) {
                removeStudentRadio.setSelected(false);
            }

            buildAddStudentL.setText("Add Student:");
            buildToCourseL.setText("To Course:");
            updateCourseButton.setOnAction(buildACourseAction);

        };

        EventHandler<ActionEvent> removeButtonAction = (ActionEvent e) -> {
            buildAddStudentL.setText("Remove Student:");
            if (removeStudentRadio.isSelected()) {
                addStudentRadio.setSelected(false);
            }
            buildToCourseL.setText("From Course:");
            updateCourseButton.setOnAction(removeStudentAction);

        };

        removeStudentRadio.setOnAction(removeButtonAction);
        addStudentRadio.setOnAction(addStudentAction);

        StackPane mainPane = new StackPane(grid);

        var scene = new Scene(mainPane, 780, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

// validation for instructor email
// database

