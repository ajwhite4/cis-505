/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_4.BowlingShopApp;

// This Java class defines the attributes of a product subclass ball
public class Ball extends Product {
    // Private data fields for ball color
    private String color;

    // No-argument constructor to create ball with product attributes
    public Ball() {
        super();
        this.color = "";
    }

    // Accessor (getter) and Mutator (setter) methods for variables
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Override the toString method to provide a string description of the ball product
    @Override
    public String toString() {
        return super.toString() + "\n  Color: " + color + "\n";
    }
} // End Ball