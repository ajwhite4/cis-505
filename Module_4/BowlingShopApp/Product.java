/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_4.BowlingShopApp;

// This Java class defines the attributes of a product superclass
public class Product {
    // Private data fields for product code, description and price
    private String code;
    private String description;
    private double price;

    // No-argument constructor to create product
    public Product() {
        this.code = "";
        this.description = "";
        this.price = 0;
    }

    // Accessor (getter) and Mutator (setter) methods for variables
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Override the toString method to provide a string description of the product
    @Override
    public String toString() {
        return String.format("  Product Code: %s\n  Description: %s\n  Price: $%,6.2f", code, description, price);
    }
} // End Product