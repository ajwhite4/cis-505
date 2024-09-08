/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_2.SportsTeamApp;

// This Java class defines the attributes of a sports team
public class Team {
    // Private data fields for team name, array of players, and player count
    private String teamName = "";
    private String[] players = new String[20];
    private int playerCount = 0;

    // Argument constructor to create team with team name
    public Team(String teamName) {
        this.teamName = teamName;
    }

    // Argument method to add a player to the players data field
    public void addPlayer(String player) {
            players[playerCount] = player;
            playerCount++;
    }

    // Accessor (getter) methods for variables
    public String[] getPlayers() {
        return players;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public String getTeamName() {
        return teamName;
    }
} // End Team
