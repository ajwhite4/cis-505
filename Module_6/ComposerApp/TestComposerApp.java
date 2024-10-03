/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_6.ComposerApp;

import java.util.Scanner;

/**
 * This program is designed to test the Composer and MemComposerDao classes.
 * It displays a menu for a Composer App and asks the user to make a menu selection.
 * If the user selects '1', the program will display a list of composers from the Composers list.
 * If the user selects '2', the program prompts the user to enter a composer ID, then searches
 * the Composers list for that ID. If a composer is found, details with be displayed, if not,
 * the program will display a message to the user.
 * If the user selects '3', the program prompts user for composer details and adds composer 
 * to the Composers list.
 * If the user selects '4', the program will display message and exit.
 */
public class TestComposerApp {

    public static void main(String[] args) {
        MemComposerDao composerDao = new MemComposerDao();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Display welcome message
        System.out.println("  Welcome to the Composer App\n");

        // Stay in application until the user selects '4' to exit
        while (!exit) {
            // Display menu
            System.out.println("  MENU OPTIONS");
            System.out.println("    1. View Composers");
            System.out.println("    2. Find Composer");
            System.out.println("    3. Add Composer");
            System.out.println("    4. Exit\n");
            System.out.print("  Please choose an option: ");

            // Collect user input
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            // Handle user input
            switch (option) {
                // Show all composers
                case 1:
                    System.out.println("\n\n  --DISPLAYING COMPOSERS--");
                    // Iterate through list of Composers and display
                    for (Composer composer : composerDao.findAll()) {
                        System.out.println(composer);
                    }
                    System.out.println();
                    break;
                // Find composer by ID
                case 2:
                    // Prompt and collect composer ID from user
                    System.out.print("\n  Enter an id: ");
                    int id = scanner.nextInt();
                    
                    // Search composers list for composer by ID
                    Composer composer = composerDao.findBy(id);
                    
                    // If composer is found, print details. If not, display message.
                    if (composer != null) {
                        System.out.println("\n\n  --DISPLAYING COMPOSER--");
                        System.out.println(composer);
                    } else {
                        System.out.println("\n  Composer not found");
                    }
                    break;
                // Add a new composer
                case 3:
                    // Prompt user to enter composer details
                    System.out.print("\n  Enter an id: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("  Enter a name: ");
                    String name = scanner.nextLine();
                    System.out.print("  Enter a genre: ");
                    String genre = scanner.nextLine();

                    // Create new composer object
                    Composer newComposer = new Composer(newId, name, genre);
                    // Insert composer object into list
                    composerDao.insert(newComposer);
                    System.out.println();
                    break;
                // Exit
                case 4:
                    exit = true;
                    System.out.println("\n  Program terminated by the user...");
                    break;
                // Display error message if invalid selection
                default:
                    System.out.println("  Invalid option. Please try again.");
            }
        }
        // Close scanner
        scanner.close();
    } // End main
} // End TestComposerApp
