/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_4.BowlingShopApp;

// This Java class defines the attributes of a product subclass shoe
public class Shoe extends Product {
    // Private data fields for shoe size
    private double size;

    // No-argument constructor to create shoe with product attributes
    public Shoe() {
        super();
        this.size = 0;
    }

    // Accessor (getter) and Mutator (setter) methods for variables
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    // Override the toString method to provide a string description of the shoe product
    @Override
    public String toString() {
        return super.toString() + "\n  Size: " + size + "\n";
    }
} // End Shoe