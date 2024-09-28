/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_5.ExpenseTracker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// This Java class defines the attributes to represent an expense transaction
public class Transaction {
    // Private data fields for transaction
    private String date;
    private String description;
    private double amount;

    // No-argument constructor to create transaction with default attributes
    public Transaction() {
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        this.description = "";
        this.amount = 0;
    }

    // Argument constructor to create transaction with specified attributes
    public Transaction(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    // Accessor (getter) and Mutator (setter) methods for variables
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Override the toString method to provide a string description of the transaction
    @Override
    public String toString() {
        return String.format("\n  Date: %s\n  Description: %s\n  Amount: $%,6.2f", date, description, amount);
    }
} // End Transaction
