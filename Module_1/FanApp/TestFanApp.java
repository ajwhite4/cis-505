/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_1.FanApp;

/**
 * This program is designed to test the Fan class. It creates two instances of the Fan class,
 * one default, and one custom. Then the toString() method will be called to describe each object.
 */
public class TestFanApp {
    public static void main(String[] args) {
        // Create a default fan using the no-argument constructor
        Fan defaultFan = new Fan();

        // Create a fan using the argument constructor
        Fan customFan = new Fan(Fan.MEDIUM, true, 8, "Blue");

        // Display the default fan using toString()
        System.out.println(defaultFan.toString());

        // Display the custom fan using toString()
        System.out.println(customFan.toString());
    } // end main
} // end TestFanApp
