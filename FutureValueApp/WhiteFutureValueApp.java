/*
    Shelanskey, T. (2024). CIS Intermediate Java Programming. Bellevue University.
    Modified by A. White 2024
*/
package FutureValueApp;

// Import JavaFX packages
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/** 
 * This application lays out a user interface for the FutureValueApp.
 * It shows that JavaFX is installed and configured properly in VS Code.
 */
public class WhiteFutureValueApp extends Application {
    
    // Declare UI controls as private variables
    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate = new TextField();
    private TextArea txtResults = new TextArea();
    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblNumOfYears = new Label("Years:");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private Label lblFutureValueDate = new Label();
    private ComboBox<Integer> cbYears = new ComboBox<>();
    private Button btnCalculate = new Button("Calculate");;
    private Button btnClear = new Button("Clear");

    @Override
    public void start(Stage primaryStage) {
        // Create GridPane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        
        // Layout objects in GridPane according to "Exhibit A. Final Solution Output"
        lblInterestRateFormat.setTextFill(Color.RED);
        pane.add(lblInterestRateFormat, 1, 2);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);
        GridPane.setHalignment(txtMonthlyPayment, HPos.RIGHT);
        GridPane.setHalignment(txtInterestRate, HPos.RIGHT);
        GridPane.setHalignment(cbYears, HPos.RIGHT);
        GridPane.setHalignment(lblMonthlyPayment, HPos.LEFT);
        txtMonthlyPayment.setMaxWidth(175);
        txtInterestRate.setMaxWidth(175);
        cbYears.setMaxWidth(175);
        pane.add(lblMonthlyPayment, 0, 0);
        pane.add(txtMonthlyPayment, 1, 0);
        pane.add(lblInterestRate, 0, 1);
        pane.add(txtInterestRate, 1, 1);
        pane.add(lblNumOfYears, 0, 3);
        pane.add(cbYears, 1, 3);

        // Add values to ComboBox
        cbYears.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Set Layout and HBox configuration
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().add(btnClear);
        actionBtnContainer.getChildren().add(btnCalculate);
        actionBtnContainer.setAlignment(Pos.CENTER_RIGHT);
        pane.add(actionBtnContainer, 1, 4);

        // Add TextArea for Future Value
        pane.add(lblFutureValueDate, 0, 5);
        pane.add(txtResults, 0, 6);
        GridPane.setColumnSpan(txtResults, 2);

        
        // Set stage title
        primaryStage.setTitle("White Future Value App");

        // Create scene and add it to the stage
        Scene scene = new Scene(pane, 315, 355);
        primaryStage.setScene(scene);
        primaryStage.show();
    } // End start

    public static void main(String[] args) {
        launch(args);
    } // End main
} // End WhiteFutureValueApp