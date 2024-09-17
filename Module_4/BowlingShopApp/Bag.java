/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_4.BowlingShopApp;

// This Java class defines the attributes of a product subclass bag
public class Bag extends Product {
    // Private data fields for bag type
    private String type;

    // No-argument constructor to create bag with product attributes
    public Bag() {
        super();
        this.type = "";
    }

    // Accessor (getter) and Mutator (setter) methods for variables
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Override the toString method to provide a string description of the bag product
    @Override
    public String toString() {
        return super.toString() + "\n  Type: " + type + "\n";
    }
} // End Bag