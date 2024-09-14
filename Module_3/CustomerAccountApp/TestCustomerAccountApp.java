/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_3.CustomerAccountApp;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program is designed to test the Customer, CustomerDB, and Account classes. 
 * It asks for a customer ID, retrieves the customer data, presents the user with a menu
 * to deposit, withdraw, and check balance. After a selection is completed it will ask
 * the user if they want to continue and if not, they will be shown a customer summary
 * and balance.
 */
public class TestCustomerAccountApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account();

        // Display welcome message
        System.out.println("  Welcome to the Customer Account App\n");

        // Set variable values
        int customerId = 0;
        boolean validCustId = false;

        // Ensure valid customer id input
        while (!validCustId) {
            try {
                // Prompt the user for customer id
                System.out.print("  Enter a customer ID\n" +
                                 "    ex: 1007, 1008, 1009>: ");
                customerId = sc.nextInt();
                validCustId = true;
            } catch (InputMismatchException e) {
                // Throw error if non-numerical value is entered
                System.out.println("\n  Error: Invalid input. Customer ID's are numeric.\n");
                // Clear the input
                sc.next();
            }
        }

        // Retrieve the customer object corresponding to the entered customer ID from CustomerDB
        Customer customer = CustomerDB.getCustomer(customerId);

        // Control whether the menu continues to display
        boolean continueMenu = true;
        do {
            // Display account menu options
            account.displayMenu();
            
            // Read user input and convert to uppercase for processing
            String option = sc.next().toUpperCase();

            boolean validInput = false;

            // Handle user input
            switch (option) {
                case "B":
                    // Display account balance
                    System.out.printf("\n  Account balance: $%,6.2f", account.getBalance());
                    break;
                case "D":
                    while (!validInput) {
                        try {
                            // Prompt user for deposit amount and update balance
                            System.out.print("\n  Enter deposit amount: ");
                            double depositAmount = sc.nextDouble();
                            account.deposit(depositAmount);
                            validInput = true;
                        } catch (InputMismatchException e) {
                            // Throw error if non-numerical value is entered
                            System.out.println("\n  Error: Invalid input.");
                            // Clear the input
                            sc.next();
                        }
                    }
                    break;
                case "W":
                    while (!validInput) {
                        try {
                            // Prompt user for withdraw amount and update balance
                            System.out.print("\n  Enter withdraw amount: ");
                            double withdrawAmount = sc.nextDouble();
                            account.withdraw(withdrawAmount);
                            validInput = true;
                        } catch (InputMismatchException e) {
                            // Throw error if non-numerical value is entered
                            System.out.println("\n  Error: Invalid input.");
                            // Clear the input
                            sc.next();
                        }
                    }
                    break;
                default:
                    // Display error message for invalid menu entries
                    System.out.println("\n  Error: Invalid Option.");
                    break;
            }

            if (continueMenu) {
                // Ask if user wants to stay in the menu
                System.out.print("\n  Continue? (y/n): ");
                String response = sc.next().toUpperCase();

                // If user input is not 'Y' or 'N', display error message and reprompt
                while (!response.equals("Y") && !response.equals("N")) {
                    System.out.println("\n  Error: Invalid Option.");
                    System.out.print("\n  Continue? (y/n): ");
                    response = sc.next().toUpperCase();
                }
                // If 'N', set continueMenu to false to break the do/while loop
                if (response.equals("N")) {
                    continueMenu = false;
                }
            }
        } while (continueMenu);

        // Close the scanner
        sc.close();

        // Display customer details and account balance
        System.out.println("\n\n" + customer);
        System.out.printf("\n  Balance as of %s is $%,6.2f\n\n  End of Line...", account.getTransactionDate(), account.getBalance());
    } // End main
} // End TestCustomerAccountApp