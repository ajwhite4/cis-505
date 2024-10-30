/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package GradeBookApp;

// Import JavaFX packages
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/** 
 * This application is built to assist in tracking student performance.
 * It will ask the user to enter first, last, and course name as well as select a grade.
 * Upon selecting the save button, the application will record the grade to a CSV file.
 * Selecting the "Clear" button will clear all of the input fields.
 * Selecting the "view grades" button will display the contents of the CSV file.
 */
public class WhiteGradeBookApp extends Application {

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
        // Create GridPane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(20, 20, 20, 20));

        // Layout objects in GridPane according to "Exhibit A. Final Solution Output"
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
        HBox buttonBox = new HBox(15); // Horizontal box for buttons
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

        // Set stage title
        primaryStage.setTitle("White GradeBook App");

        // Create scene and add it to the stage
        Scene scene = new Scene(layout, 525, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    } // End start

    public static void main(String[] args) {
        launch(args);
    } // End main
} // End WhiteGradeBookApp
