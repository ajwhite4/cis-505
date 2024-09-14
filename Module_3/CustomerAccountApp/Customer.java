/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package Module_3.CustomerAccountApp;

// This Java class defines the attributes of a customer
public class Customer {
    // Private data fields for name, address, city, and zip for customer
    private String name;
    private String address;
    private String city;
    private String zip;

    // No-argument default constructor
    public Customer() {
        this.name = "John Doe";
        this.address = "123 First Street";
        this.city = "Bellevue";
        this.zip = "68005";
    }

    // Argument constructor to create customer with name, address, city, and zip
    public Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    // Accessor methods for variables
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    // Override the toString method to provide a string summary of the customer
    @Override
    public String toString() {
        return "  --Customer Details--\n" +
               "  Name: " + name + "\n" +
               "  Address: " + address + "\n" +
               "  City: " + city + "\n" +
               "  Zip: " + zip;
    }
} // End Customer