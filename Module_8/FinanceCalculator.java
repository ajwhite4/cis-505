/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_8;

// This class defines the attributes and methods to represent a finance calculator
public class FinanceCalculator {
    // Private data fields for FinanceCalculator
    private static final int MONTHS_IN_YEAR = 12;

    // Method to calculate the future value
    public static double calculateFutureValue(double monthlyPayment, double rate, int years) {
        // Calculate the number of months
        int months = years * MONTHS_IN_YEAR;
        
        // Calculate interest rate
        double interestRate = 1 + rate / 100;
        
        // Calculate present value
        double presentValue = monthlyPayment * months;
        
        // Calculate future value using the provided formula
        double futureValue = presentValue * (Math.pow(interestRate, months));

        return futureValue;
    }
}
