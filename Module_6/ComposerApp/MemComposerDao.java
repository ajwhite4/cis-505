/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_6.ComposerApp;

import java.util.ArrayList;
import java.util.List;

// This Java class represents operations in a composer data persistence layer.
public class MemComposerDao implements ComposerDao {
    // List to hold Composer objects
    private List<Composer> composers;

    // No-argument constructor that initializes the composers list with values.
    public MemComposerDao() {
        composers = new ArrayList<>();
        // Add predefined composers to the list
        composers.add(new Composer(1007, "Ludwig van Beethoven", "Classical"));
        composers.add(new Composer(1008, "Johann Sebastian Bach", "Classical"));
        composers.add(new Composer(1009, "Wolfgang Amadeus Mozart", "Classical"));
        composers.add(new Composer(1010, "Johannes Brahms", "Classical"));
        composers.add(new Composer(1011, "Joseph Haydn", "Classical"));
    }

    // Method to override the list of composers
    @Override
    public List<Composer> findAll() {
        return composers;
    }

    // Method to find a composer by their ID
    @Override
    public Composer findBy(Integer id) {
        // Iterate through the list to check for composer with matching ID
        for (Composer composer : composers) {
            // If there is a match, return the composer object
            if (composer.getId() == id) {
                return composer;
            }
        }
        // Return null if no composer is found
        return null;
    }

    // Method to add a composer to the composers list
    @Override
    public void insert(Composer composer) {
        composers.add(composer);
    }
} // End MemComposerDao
