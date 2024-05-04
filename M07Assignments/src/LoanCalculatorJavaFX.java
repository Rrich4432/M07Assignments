import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoanCalculatorJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Loan Payment Calculator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label loanAmountLabel = new Label("Loan Amount:");
        GridPane.setConstraints(loanAmountLabel, 0, 0);
        TextField loanAmountField = new TextField();
        GridPane.setConstraints(loanAmountField, 1, 0);

        Label annualInterestRateLabel = new Label("Annual Interest Rate (%):");
        GridPane.setConstraints(annualInterestRateLabel, 0, 1);
        TextField annualInterestRateField = new TextField();
        GridPane.setConstraints(annualInterestRateField, 1, 1);

        Label numberOfYearsLabel = new Label("Number of Years:");
        GridPane.setConstraints(numberOfYearsLabel, 0, 2);
        TextField numberOfYearsField = new TextField();
        GridPane.setConstraints(numberOfYearsField, 1, 2);

        Button calculateButton = new Button("Compute Loan Payment");
        GridPane.setConstraints(calculateButton, 1, 3);

        Label resultLabel = new Label();
        GridPane.setConstraints(resultLabel, 0, 4);

        grid.getChildren().addAll(loanAmountLabel, loanAmountField, annualInterestRateLabel, annualInterestRateField,
                numberOfYearsLabel, numberOfYearsField, calculateButton, resultLabel);

        calculateButton.setOnAction(e -> {
            double loanAmount = Double.parseDouble(loanAmountField.getText());
            double annualInterestRate = Double.parseDouble(annualInterestRateField.getText());
            int numberOfYears = Integer.parseInt(numberOfYearsField.getText());

            Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);

            resultLabel.setText("Monthly Payment: $" + loan.getMonthlyPayment() + "\n" +
                    "Total Payment: $" + loan.getTotalPayment());
        });

        Scene scene = new Scene(grid, 350, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
