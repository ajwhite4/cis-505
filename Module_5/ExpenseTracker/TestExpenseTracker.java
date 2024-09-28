/*
    Shelanskey, T. (2024). CIS Intermediate Java Programming. Bellevue University.
    Modified by A. White 2024
*/
package Module_5.ExpenseTracker;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program is designed to test the transaction, TransactionIO, and ValidatorIO classes.
 * It displays a menu for an expense tracker and asks the user to make a menu selection.
 * If the user selects '1', the program will display a list of transactions in expenses.txt.
 * If the user selects '2', the program prompts the user to enter a description and price.
 * If the user selects '3', the program calculates the combined cost of all items in the expenses.txt file
 * and displays the total cost to the user.
 */
public class TestExpenseTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true;

        // Display welcome message
        System.out.println("  Welcome to the Expense Tracker");

        // Stay in application until the user doesn't want to continue
        while (continueProgram) {
            // display menu and collect user input
            int input = ValidatorIO.getInt(sc, menu());
            
            // handle user input
            if (input == 1) {
                // display all transactions in expenses.txt file
                System.out.println("\n  MONTHLY EXPENSES");
                try {
                    ArrayList<Transaction> transactions = TransactionIO.findAll();
                    for (Transaction t : transactions) {
                        System.out.println(t);
                    }
                } catch (IOException e) {
                    System.out.println("\n  Error reading the file.");
                }
            } else if (input == 2){
                /*
                 * prompt user to enter description and price for transaction and reprompt if they want to add 
                 * additional transactions.
                 */
                String c = "y";
                ArrayList<Transaction> transactions = new ArrayList<>();
                
                while (c.equalsIgnoreCase("y")) {
                    String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
                    String description = ValidatorIO.getString(sc, "\n  Enter the transaction description: ");
                    double amount = ValidatorIO.getDouble(sc, "  Enter the transaction amount: ");
                    
                    Transaction transaction = new Transaction(date, description, amount);
                    
                    // add transactions to object
                    transactions.add(transaction);
        
                    c = ValidatorIO.getString(sc, "\n  Add another transaction? (y/n): ");
                }
        
                // add transactions to expenses.txt file
                try {
                    TransactionIO.bulkInsert(transactions);
                } catch (IOException e) {
                    System.out.println("\n  Error writing to the file.");
                }

            } else if (input == 3){
                // Calculate and display total expenses from expenses.txt file to user
                try {
                    ArrayList<Transaction> transactions = TransactionIO.findAll();
                    double monthlyExpense = 0;
                    // iterate through file to add each amount together
                    for (Transaction transaction : transactions) {
                        monthlyExpense += transaction.getAmount();
                    }
                    // display total monthly expense
                    System.out.printf("\n  Your total monthly expense is $%,6.2f\n", monthlyExpense);
                } catch (IOException e) {
                    System.out.println("\n  Error reading the file.");
                }
            } else {
                System.out.println("\n  Invalid choice. Please try again.");
            }

            // prompt user if they want to continue
            System.out.print("\n  Continue? (y/n): ");
                String response = sc.next();
                // if not 'y', terminate program
                if (!response.equalsIgnoreCase("y")) {
                    continueProgram = false;
                    System.out.println("\n  Program terminated by the user...");
                }
        }
    } // End Main

    // Method to display the menu
    public static String menu() {
        return("\n  MENU OPTIONS\n" +
            "    1. View Transactions\n" +
            "    2. Add Transactions\n" +
            "    3. View Expense\n\n" +
            "  Please choose an option: ");
    } // End Menu
} // End TestExpenseTracker
