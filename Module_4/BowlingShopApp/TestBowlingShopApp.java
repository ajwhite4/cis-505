/*
    Shelanskey, T. (2024). CIS Intermediate Java Programming. Bellevue University.
    Modified by A. White 2024
*/
package Module_4.BowlingShopApp;

import java.util.Scanner;

/**
 * This program is designed to test the Product superclass and Ball, Bag, and Shoe subclasses.
 * It displays a menu for a Bowling Shop and asks the user to make a menu selection.
 * If the user selects 'b', 'a', or 's', the program will use the GenericQueue class to store
 * a list of products (based on user selection) and display the products. If the user selection
 * is not 'x' and not a valid product, an empty product list will be displayed.
 * If the user selects 'x' at the menu, the program will exit.
 */
public class TestBowlingShopApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String option = "";

        // Display welcome message
        System.out.println("  Welcome to the Bowling Shop\n");

        // Stay in application, displaying menu until user selects 'x' to exit
        while (!option.equalsIgnoreCase("x")) {
            // Display menu and prompt user for menu selection
            displayMenu();
            option = scanner.nextLine();

            if (!option.equals("x")) {
                // create queue and populate with products based on menu selection
                GenericQueue<Product> products = ProductDB.getProducts(option);
                
                // Display list of products
                System.out.println("\n  --Product Listing--");
                while (products.size() > 0) {
                    Product product = products.dequeue();
                    System.out.println(product.toString());
                }
            }
        }
        // Exit program and close scanner
        System.out.println("\n\n  End of Line...");
        scanner.close();
    } // End main

    public static void displayMenu() {
        System.out.println("\n  MENU OPTIONS");
        System.out.println("    1. <b> Bowling Balls");
        System.out.println("    2. <a> Bowling Bags");
        System.out.println("    2. <s> Bowling Shoes");
        System.out.println("    4. <x> To exit");
        System.out.print("\n  Please choose an option: ");
    } // displayMenu
} // End TestBowlingShopApp