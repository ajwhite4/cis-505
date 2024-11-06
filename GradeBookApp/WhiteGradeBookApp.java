/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package GradeBookApp;

// Import Java and JavaFX packages
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/** 
 * This application is built to assist in tracking student performance.
 * It will ask the user to enter first, last, and course name as well as select a grade.
 * Upon selecting the save button, the application will record the grade to a CSV file.
 * Selecting the "Clear" button will clear all of the input fields.
 * Selecting the "view grades" button will display the contents of the CSV file.
 */
public class WhiteGradeBookApp extends Application {

    // Declare UI controls as private variables
    private TextField firstNameField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField courseField = new TextField();
    private TextArea txtResults = new TextArea();
    private Label firstNameLabel = new Label("First Name:");
    private Label lastNameLabel = new Label("Last Name:");
    private Label courseLabel = new Label("Course Name:");
    private Label gradeLabel = new Label("Grade:");
    private Label lblResults = new Label();
    private ComboBox<String> gradeComboBox = new ComboBox<>();
    private Button saveButton = new Button("Save");
    private Button viewButton = new Button("View Grades");
    private Button clearButton = new Button("Clear");
    
    @Override
    public void start(Stage primaryStage) {
        // Set properties of txtResults to display grades neatly
        txtResults.setEditable(false);
        txtResults.setPrefHeight(200);
        txtResults.setPrefWidth(575);
        txtResults.setWrapText(false);
        txtResults.setFont(javafx.scene.text.Font.font("Courier New", 12));
        firstNameField.setMaxWidth(200);
        lastNameField.setMaxWidth(200);
        courseField.setMaxWidth(200);
        
        // Create GridPane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(20, 20, 20, 20));

        // Layout objects in GridPane
        pane.add(firstNameLabel, 0, 0);
        pane.add(firstNameField, 1, 0);
        pane.add(lastNameLabel, 0, 1);
        pane.add(lastNameField, 1, 1);
        pane.add(courseLabel, 0, 2);
        pane.add(courseField, 1, 2);
        pane.add(gradeLabel, 0, 3);
        pane.add(gradeComboBox, 1, 3);
        pane.add(saveButton, 0, 4);
        pane.add(viewButton, 1, 4);
        pane.add(clearButton, 2, 4);

        // Add values to ComboBox
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "F");
        gradeComboBox.setPrefWidth(100);

        // Set Layout and HBox configuration
        HBox buttonBox = new HBox(15);
        buttonBox.getChildren().addAll(clearButton, viewButton, saveButton);
        buttonBox.setAlignment(Pos.CENTER);
        
        // BorderPane to organize the layout
        BorderPane layout = new BorderPane();
        layout.setCenter(pane);
        layout.setBottom(buttonBox);
        BorderPane.setMargin(buttonBox, new Insets(10, 0, 10, 0));

        // Add TextArea for grades.csv file contents
        pane.add(lblResults, 0, 5);
        pane.add(txtResults, 0, 6);
        GridPane.setColumnSpan(lblResults, 2);
        GridPane.setColumnSpan(txtResults, 2);

        // Handlers for btn clicks
        saveButton.setOnAction(e -> saveGrade());
        viewButton.setOnAction(e -> viewGrades());
        clearButton.setOnAction(e -> clearForm());

        // Set stage title
        primaryStage.setTitle("White GradeBook App");

        // Create scene and add it to the stage
        Scene scene = new Scene(layout, 600, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    } // End start

    // Method to save form data to grades.csv
    private void saveGrade() {
        // Get values of user inputs
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String courseName = courseField.getText();
        String grade = gradeComboBox.getValue();

        // Check for empty fields and return message if any are empty
        if (firstName.isEmpty() || lastName.isEmpty() || courseName.isEmpty() || grade == null) {
            lblResults.setText("All fields required.");
            lblResults.setTextFill(Color.RED);
            return;
        }

        // Write to grades.csv
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("grades.csv", true))) {
            File file = new File("grades.csv");
            // Write header if file is empty
            if (file.length() == 0) {
                writer.write("firstName,lastName,course,grade"); 
            }
            writer.write("\n" + firstName + "," + lastName + "," + courseName + "," + grade);
            // Clear form and give success message after saving
            clearForm();
            lblResults.setText("Save Successful.");
            lblResults.setTextFill(Color.GREEN);
        } catch (IOException ex) {
            // Display error if exception
            lblResults.setText("Error saving the grade.");
            lblResults.setTextFill(Color.RED);
            ex.printStackTrace();
        }
    }

    // Method to view saved grades in grades.csv
    private void viewGrades() {
        // Create list of students
        List<Student> students = new ArrayList<>();
        // Try reading grades.csv 
        try (BufferedReader reader = new BufferedReader(new FileReader("grades.csv"))) {
             // Skip header line
            String line = reader.readLine();
            // Create a new student to add to list for each record in grades.csv
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    Student student = new Student(data[0], data[1], data[2], data[3]);
                    students.add(student);
                }
            }
            // Check if grades.csv is empty
            if (students.isEmpty()) {
                txtResults.setText("No grades found.");
            } else {
                StringBuilder sb = new StringBuilder();
                // Add and format results to display neatly
                sb.append(String.format("%-20s %-20s %-20s %-5s\n", "First Name", "Last Name", "Course Name", "Grade"));
                sb.append("=".repeat(70)).append("\n");
                for (Student s : students) {
                    sb.append(s.toString()).append("\n");
                }
                // Print formatted string of students 
                txtResults.setText(sb.toString());
                lblResults.setText(null);
            }
        } catch (FileNotFoundException ex) {
            // Display message if file not found
            lblResults.setText("grades.csv not found.");
            lblResults.setStyle("-fx-text-fill: red;");
            txtResults.setText("");
            ex.printStackTrace();
        } catch (IOException ex) {
            // Display message if any other exception
            lblResults.setText("Error reading grades.");
            lblResults.setStyle("-fx-text-fill: red;");
            txtResults.setText("");
            ex.printStackTrace();
        }
    }

    // Method to clear the form fields
    private void clearForm() {
        firstNameField.clear();
        lastNameField.clear();
        courseField.clear();
        gradeComboBox.setValue(null);
        txtResults.clear();
        lblResults.setText(null);
    }

    public static void main(String[] args) {
        launch(args);
    } // End main
} // End WhiteGradeBookApp
