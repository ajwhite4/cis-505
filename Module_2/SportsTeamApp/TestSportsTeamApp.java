/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_2.SportsTeamApp;

import java.util.Scanner;

/**
 * This program is designed to test the Team class. It allows the user to create a team and add players
 * to that team. A team summary is displayed to the user and the user is asked if they want to continue.
 * The program will terminate
 */
public class TestSportsTeamApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("  Welcome to the Sports Team App\n");
        while (!exit) {
            // Prompt user for team name
            System.out.print("  Enter a team name: ");
            String teamName = scanner.nextLine();

            // Create a Team using the argument constructor
            Team team = new Team(teamName);

            // Prompt user for player names
            System.out.println("\n  Enter the player names:");
            System.out.print("    hint: use commas for multiple players; no spaces>: ");
            String playersInput = scanner.nextLine();
            String[] players = playersInput.split(",");

            // Iterate through each player entered, using the addPlayer method to add each player to the team
            for (String player : players) {
                team.addPlayer(player);
            }

            // Display the team summary, stating the number of players on the team, and list the players 
            System.out.println("\n  --Team Summary--");
            System.out.println("  Number of players in team: " + team.getPlayerCount());
            System.out.print("  Players on team: ");
            for (int i = 0; i < team.getPlayerCount(); i++) {
                System.out.print(team.getPlayers()[i]);
                if (i < team.getPlayerCount() - 1) {
                    System.out.print(",");
                }
            }

            // Ask if the user wants to continue, if "y", go to the beginning of the while loop.
            System.out.print("\n\n  Continue? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("y")) {
                exit = true;
            } 
            System.out.println();
        } // End while loop

        scanner.close();
        System.out.println("\n  End of line...");
    } // End main
} // End TestSportsTeamApp
