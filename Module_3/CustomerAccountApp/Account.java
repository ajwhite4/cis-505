/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_3.CustomerAccountApp;

import java.text.SimpleDateFormat;
import java.util.Date;

// This Java class defines the attributes of an account
public class Account {
    // Private data field for account balance
    private double balance = 200;

    // Accessor for balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit amount
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw amount
    public void withdraw(double amount) {
        // Process withdrawal if balance greater or equal to amount
        if (balance >= amount) {
            balance -= amount;
        } 
        // Display message if withdraw amount greater than balance
        else {
            System.out.println("\n  Insufficient balance.");
        }
    }

    // Method to display account menu
    public void displayMenu() {
        System.out.print("\n  Account Menu\n" +
                         "  Enter <D/d> for deposit\n" +
                         "  Enter <W/w> for withdraw\n" +
                         "  Enter <B/b> for balance\n" +
                         "    Enter option>: ");
    }

    // Method to return transaction date
    public String getTransactionDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        return sdf.format(new Date());
    }
} // End Account