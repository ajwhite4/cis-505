/*
    Shelanskey, T. (2024). CIS Intermediate Java Programming. Bellevue University.
    Modified by A. White 2024
*/
package Module_8;

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
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * This application lays out a user interface for the FutureValueApp.
 * It shows that JavaFX is installed and configured properly in VS Code.
 */
public class WhiteEnhancedFutureValueApp extends Application {
    
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
        for (int i = 0; i <= 20; i++) {
            cbYears.getItems().add(i);
        }
        // Set default years to 0
        cbYears.setValue(0);
        
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
        GridPane.setColumnSpan(lblFutureValueDate, 2);
        GridPane.setColumnSpan(txtResults, 2);

        // Handlers for btn clicks
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate.setOnAction(e -> calculateResults());
        
        // Set stage title
        primaryStage.setTitle("White Future Value App");

        // Create scene and add it to the stage
        Scene scene = new Scene(pane, 315, 355);
        primaryStage.setScene(scene);
        primaryStage.show();
    } // End start

    // Method to clear form fields
    private void clearFormFields() {
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        txtResults.setText("");
        lblFutureValueDate.setText("");
        cbYears.setValue(0);
    } // End clearFormFields

    // Method to calculate results
    private void calculateResults() {
        try {
            // Get values of user inputs
            double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText());
            double interestRate = Double.parseDouble(txtInterestRate.getText());
            int years = cbYears.getValue();

            // Call FinanceCalculator to calculate future value
            double futureValue = FinanceCalculator.calculateFutureValue(monthlyPayment, interestRate, years);

            // Set the date label and result text
            lblFutureValueDate.setText("Calculation as of " + getTodaysDate());
            txtResults.setText(String.format("The future value is $%,6.2f", futureValue));
        } catch (NumberFormatException e) {
            txtResults.setText("Invalid input. Please enter numerical values for payment and interest.");
        }
    } // End calculateResults

    // Method to get today's date in 'MM/dd/yyyy' format
    private String getTodaysDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(new Date());
    } // End getTodayDate

    public static void main(String[] args) {
        launch(args);
    } // End main
} // End WhiteFutureValueApp