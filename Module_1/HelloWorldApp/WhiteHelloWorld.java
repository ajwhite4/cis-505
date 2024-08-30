/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_1.HelloWorldApp;

// This Java program prints a "Hello World from {YourFirstName} {YourLastName}" message to the console
public class WhiteHelloWorld {
    public static void main(String[] args) {
        // Declare and initialize a String variables to store "Andrew" and "White"
        String firstName = "Andrew";
        String lastName = "White";

        /**
         * Print a formatted message to the console using the firstName and lastName variables.
         * The %s format specifier will be replaced by the values of firstName and lastName.
         */ 
        System.out.printf("Hello World from %s %s", firstName, lastName);
    } // end main
} // end WhiteHelloWorld
