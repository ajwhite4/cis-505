/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_1.HelloWorldApp;

public class WhiteHelloWorld {
    /**
     * This program prints "Hello World from {YourFirstName} {YourLastName}" to the console using 
     * String variables for the first and last names.
     */ 
    public static void main(String[] args) {
        // Declare string variables for first and last name
        String firstName = "Andrew";
        String lastName = "White";

        /**
         * Output the string using printf
         * The %s format specifier is used to insert the string variables into the output.
         */ 
        System.out.printf("Hello World from %s %s", firstName, lastName);
    } // end main
} // end WhiteHelloWorld