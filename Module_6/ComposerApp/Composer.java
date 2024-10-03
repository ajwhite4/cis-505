/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_6.ComposerApp;

// This Java class defines the attributes to represent a Composer
public class Composer {
    // Private data fields for composer
    private int id;
    private String name;
    private String genre;

    // No-argument constructor to create composer with default attributes
    public Composer() {
        this.id = 0;
        this.name = "";
        this.genre = "";
    }

    // Argument constructor to create composer with specified attributes
    public Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    // Accessor (getter) and Mutator (setter) methods for variables
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Override the toString method to provide a string description of the composer
    @Override
    public String toString() {
        return String.format("  Id: %d\n  Name: %s\n  Genre: %s\n", id, name, genre);
    }
} // End Composer
