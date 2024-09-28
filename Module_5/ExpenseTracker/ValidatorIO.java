/*
    Shelanskey, T. (2024). CIS Intermediate Java Programming. Bellevue University.
    Modified by A. White 2024
*/
package Module_5.ExpenseTracker;

import java.util.Scanner;

// This Java class defines methods to validate invalid user entries
public class ValidatorIO {

    // method to validate that an input is an integer
    public static int getInt(Scanner sc, String prompt) {
        int input = 0;
        boolean isValid = false;
        // Display prompt until valid integer input
        while (!isValid) {
            // Display prompt
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                // capture user input if integer
                input = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("\n  Error! Invalid integer value.");
            }
            // clear invalid input
            sc.nextLine();
        }
        return input;
    }

    // method to validate that an input is a double
    public static double getDouble(Scanner sc, String prompt) {
        double input = 0.0;
        boolean isValid = false;
        // Display prompt until valid double input
        while (!isValid) {
            // Display prompt
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                // capture user input if integer
                input = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("\n  Error! Invalid double value.");
            }
            // clear invalid input
            sc.nextLine();
        }
        return input;
    }

    // method to display a prompt message and return the users input string
    public static String getString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
} // End ValidatorIO